import { AiFillMessage } from "react-icons/ai";
import { FaUser } from "react-icons/fa";
import { AiOutlineBell } from "react-icons/ai";
import styles from "./Header.module.css";

const Header = () => {
  return (
    <>
      <div className={styles["header-wrapper"]}>
        <div className={styles["username-wrapper"]}>
            <h3> Hello, Siva</h3>
        </div>
        <div className={styles["icon-wrapper"]}>
          <AiOutlineBell className={styles["icon-config"]} />
          <AiFillMessage className={styles["icon-config"]} />
          <FaUser className={styles["icon-config"]} />
        </div>
      </div>
    </>
  );
};

export default Header;
