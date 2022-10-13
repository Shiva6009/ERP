import React from "react";
import styles from "./WrapperDashboard.module.css";

const WrapperDashboard = () => {
  return (
    <>
      <div className={styles["grid-container"]}>
       
        <div className={styles.header}>
          <h1> Header</h1>
        </div>

        <div className={styles["center-div"]}>
          <div className={styles.sidepanel}>
            <h1> Side </h1>
          </div>

          <div  className={styles.maincontent}>
            <h1> Main </h1>
          </div>
        </div>

        <div className={styles.footer}>

        </div>



      </div>
    </>
  );
};

export default WrapperDashboard;
