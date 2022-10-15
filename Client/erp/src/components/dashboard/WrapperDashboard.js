import React from "react";
import styles from "./WrapperDashboard.module.css";
import Header from "./Header";
import SidePanel from "./SidePanel";


const WrapperDashboard = () => {
  return (
    <>
      <div className={styles["grid-container"]}>
      
        <div className={styles.header}>
          <Header />
        </div>

        <div className={styles["center-div"]}>
          <div className={styles.sidepanel}>
             <SidePanel />
          </div>

          <div className={styles.maincontent}>
            <h1> Main </h1>
          </div>
        </div>

        <div className={styles.footer}></div>
      </div>
    </>
  );
};

export default WrapperDashboard;
