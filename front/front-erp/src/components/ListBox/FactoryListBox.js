import React, { useState } from "react";
import "../ListBox/FactoryListBox.css";

const FactoryListBox = () => {
    const FactoryListData = [
        { id:0 , name:"공장1"},
        { id:1 , name:"공장2"},
        { id:2 , name:"공장3"},
        { id:3 , name:"공장4"},
        { id:4 , name:"공장5"}
    ]

    const [selectedFactory, setSelectedFactory] = useState(null);

    const handleFactoryChange = (event) => {
        const selectedId = parseInt(event.target.value);
        const selectedFactory = FactoryListData.find(factory => factory.id === selectedId);
        setSelectedFactory(selectedFactory);
    };

    return (
        <div className="factoryListBox">
            <select value={selectedFactory ? selectedFactory.id : ''} onChange={handleFactoryChange} className="FactorySelectBox">
                <option value="">공장 선택</option>
                {FactoryListData.map(factory => (
                    <option key={factory.id} value={factory.id}>{factory.name}</option>
                ))}
            </select>   
        </div>
    )
}

export default FactoryListBox;
