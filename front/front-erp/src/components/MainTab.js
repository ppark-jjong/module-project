import React, { useState } from "react";
import "../components/MainTab.css";
import OutsourcingBOM from "../pages/OutsourcingBOM/OutsourcingBOM";

const MainTab = () => {
    const TabData = [
        { id: 0, title: "외주BOM", description: <OutsourcingBOM /> },
        { id: 1, title: "외주유형관리", description: "외주유형관리 Page" },
        { id: 2, title: "공정외주발주관리", description: "공정외주발주관리 Page" },
        { id: 3, title: "외주발주관리", description: "외주발주관리 Page" },
        { id: 4, title: "계정처리유형", description: "계정처리유형 Page" },
        { id: 5, title: "Main", description: "Main Page" }
    ]

    const [index, setIndex] = useState(0);

    return (
        <section className="tabContainer">
            <ul className="tabMenu">
                {TabData.map(item => (
                    <li
                        key={item.id}
                        onClick={() => setIndex(item.id)}
                        className={index === item.id ? "selectedTab" : ""}
                    >{item.title}
                    </li>
                ))}
            </ul>
            {TabData.filter(item => index === item.id).map(item => (
                <div className="tabContent">{item.description}</div>
            ))}
        </section>
    )
}

export default MainTab;