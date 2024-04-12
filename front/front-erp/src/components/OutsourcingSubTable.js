import React, { useState } from "react";
import "../components/OutsourcingSubTable.css";

const OutsourcingSubTable = () => {
    const [checkedItems, setCheckedItems] = useState({});
    const [selectedItems, setSelectedItems] = useState({});

    const OutsourcingSubData = [
        { id: 1, item: "Item 1", description: "Description 1", specification: "Spec 1", detailSpecification: "Detail Spec 1", unit: "Unit 1", startDate: "2024-04-10", endDate: "2024-04-15", selectedType: 0, checkType: 1 },
        { id: 2, item: "Item 2", description: "Description 2", specification: "Spec 2", detailSpecification: "Detail Spec 2", unit: "Unit 2", startDate: "2024-04-11", endDate: "2024-04-16", selectedType: 1, checkType: 1 },
        { id: 3, item: "Item 3", description: "Description 3", specification: "Spec 3", detailSpecification: "Detail Spec 3", unit: "Unit 3", startDate: "2024-04-12", endDate: "2024-04-17", selectedType: 1, checkType: 0 },
        { id: 4, item: "Item 4", description: "Description 4", specification: "Spec 4", detailSpecification: "Detail Spec 4", unit: "Unit 4", startDate: "2024-04-13", endDate: "2024-04-18", selectedType: 1, checkType: 0 },
        { id: 5, item: "Item 5", description: "Description 5", specification: "Spec 5", detailSpecification: "Detail Spec 5", unit: "Unit 5", startDate: "2024-04-14", endDate: "2024-04-19", selectedType: 0, checkType: 1 },
        { id: 6, item: "Item 6", description: "Description 6", specification: "Spec 6", detailSpecification: "Detail Spec 6", unit: "Unit 6", startDate: "2024-04-15", endDate: "2024-04-20", selectedType: 1, checkType: 1 }
    ];

    const handleCheckboxChange = (id) => {
        setCheckedItems(prevState => ({
            ...prevState,
            [id]: !prevState[id]
        }));
    };

    const handleSelectChange = (event, id) => {
        const selectedType = event.target.value;
        setSelectedItems(prevState => ({
            ...prevState,
            [id]: selectedType
        }));
    };

    return (
        <div className="tableContainer">
            <table className="table">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>S</th>
                        <th>품목명</th>
                        <th>규격</th>
                        <th>세부규격</th>
                        <th>단위</th>
                        <th>유무상구분</th>
                        <th>정미소요량</th>
                        <th>LOSS</th>
                        <th>실소요량</th>
                    </tr>
                </thead>
                <tbody>
                    {OutsourcingSubData.map((item, index) => (
                        <tr key={index}>
                            <td>{item.id}</td>
                            <td>
                                <input 
                                    type="checkbox" 
                                    checked={item.checkType == 1} // 1 - 체크
                                    onChange={() => handleCheckboxChange(item.id)} 
                                />
                            </td>
                            <td>{item.item}</td>
                            <td>{item.description}</td>
                            <td>{item.specification}</td>
                            <td>{item.detailSpecification}</td>
                            <td>{item.unit}</td>
                            <td>
                                <select value={selectedItems[item.id]} onChange={(e) => handleSelectChange(e, item.id)}>
                                    <option value="">선택</option>
                                    <option value="유상" selected={item.selectedType === 1}>유상</option>
                                    <option value="무상" selected={item.selectedType === 0}>무상</option>
                                </select>
                            </td>
                            <td>{item.startDate}</td>
                            <td>{item.endDate}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}

export default OutsourcingSubTable;
