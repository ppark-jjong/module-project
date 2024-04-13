import React, { useState } from "react";
import "../ListBox/ProcurementSelect.css";

const ProcurementSelect = () => {
    const ProcurementListData = [
        { id:0 , name:"공장1"},
        { id:1 , name:"공장2"},
        { id:2 , name:"공장3"},
        { id:3 , name:"공장4"},
        { id:4 , name:"공장5"}
    ]

    const [selectedProcurement, setSelectedProcurement] = useState(null);

    const handleProcurementChange = (event) => {
        const selectedId = parseInt(event.target.value);
        const selectedProcurement = ProcurementListData.find(Procurement => Procurement.id === selectedId);
        setSelectedProcurement(selectedProcurement);
    };

    return (
        <div className="ProcurementListBox">
            <select value={selectedProcurement ? selectedProcurement.id : ''} onChange={handleProcurementChange} className="ProcurementSelectBox">
                <option value="">조달 구분</option>
                {ProcurementListData.map(Procurement => (
                    <option key={Procurement.id} value={Procurement.id}>{Procurement.name}</option>
                ))}
            </select>   
        </div>
    )
}

export default ProcurementSelect;
