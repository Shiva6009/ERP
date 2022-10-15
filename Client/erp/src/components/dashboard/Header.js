import { AiFillMessage } from "react-icons/ai";
import { FaUser } from "react-icons/fa";
import { AiOutlineBell } from "react-icons/ai";
import styles from "./Header.module.css";
import Button from "../../ui/Button";
import { loginRequest, logoutRequest } from "../../api/apirequest";

const Header = () => {
  const logInButtonHandler = () => {
    loginRequest()
      .then((response) => {
        console.log(" Success ", response);
      })
      .catch((error) => {
        console.log(" Error ", error);
      });
  };

  const logoutButtonHandler = () => {
    logoutRequest()
      .then((response) => {
        console.log(" Success ", response);
      })
      .catch((error) => {
        console.log(" Error ", error);
      });
  };

  return (
    <>
      <div className={styles["header-wrapper"]}>
        <div className={styles["username-wrapper"]}>
          <h3> Hello, Siva</h3>
        </div>
        <div className={styles["icon-wrapper"]}>
          <Button onclick={logInButtonHandler}>Login</Button>
          <Button onclick={logoutButtonHandler}>Logout</Button>
          <AiOutlineBell className={styles["icon-config"]} />
          <AiFillMessage className={styles["icon-config"]} />
          <FaUser className={styles["icon-config"]} />
        </div>
      </div>
    </>
  );
};

export default Header;
