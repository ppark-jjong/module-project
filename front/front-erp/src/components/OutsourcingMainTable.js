import React from "react";
import "../components/OutsourcingMainTable.css";

const OutsourcingMainTable = ({productSearch}) => { 
    const OutsourcingMainData = [
        { id: 1, item: "Item 1", description: "물품1", specification: "Spec 1", detailSpecification: "Detail Spec 1", unit: "Unit 1", startDate: "2024-04-10", endDate: "2024-04-15", designChangeDate: "2024-04-12", sequence: 1, ecnNumber: "ECN-001" },
        { id: 2, item: "Item 2", description: "물품2", specification: "Spec 2", detailSpecification: "Detail Spec 2", unit: "Unit 2", startDate: "2024-04-11", endDate: "2024-04-16", designChangeDate: "2024-04-13", sequence: 2, ecnNumber: "ECN-002" },
        { id: 2, item: "Item 2", description: "물품3", specification: "Spec 2", detailSpecification: "Detail Spec 2", unit: "Unit 2", startDate: "2024-04-11", endDate: "2024-04-16", designChangeDate: "2024-04-13", sequence: 2, ecnNumber: "ECN-002" },
        { id: 2, item: "Item 2", description: "물품4", specification: "Spec 2", detailSpecification: "Detail Spec 2", unit: "Unit 2", startDate: "2024-04-11", endDate: "2024-04-16", designChangeDate: "2024-04-13", sequence: 2, ecnNumber: "ECN-002" },
        { id: 2, item: "Item 2", description: "물품5", specification: "Spec 2", detailSpecification: "Detail Spec 2", unit: "Unit 2", startDate: "2024-04-11", endDate: "2024-04-16", designChangeDate: "2024-04-13", sequence: 2, ecnNumber: "ECN-002" },
        { id: 2, item: "Item 2", description: "물품6", specification: "Spec 2", detailSpecification: "Detail Spec 2", unit: "Unit 2", startDate: "2024-04-11", endDate: "2024-04-16", designChangeDate: "2024-04-13", sequence: 2, ecnNumber: "ECN-002" }
        // 나머지 데이터 추가
    ];

    const filteredProducts = OutsourcingMainData.filter(item =>
        item.description.toLowerCase().includes(productSearch.toLowerCase())
        //품목명에서 검색
    );

    return (
        <div className="tableContainer">
        <table className="table">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>품목</th>
                    <th>품목명</th>
                    <th>규격</th>
                    <th>세부규격</th>
                    <th>단위</th>
                    <th>시작일</th>
                    <th>종료일</th>
                    <th>설계변경일</th>
                    <th>차수</th>
                    <th>ECN번호</th>
                </tr>
            </thead>
            <tbody>
            {filteredProducts.map((item, index) => (
                        <tr key={index}>
                            <td>{item.id}</td>
                            <td>{item.item}</td>
                            <td>{item.description}</td>
                            <td>{item.specification}</td>
                            <td>{item.detailSpecification}</td>
                            <td>{item.unit}</td>
                            <td>{item.startDate}</td>
                            <td>{item.endDate}</td>
                            <td>{item.designChangeDate}</td>
                            <td>{item.sequence}</td>
                            <td>{item.ecnNumber}</td>
                        </tr>
                    ))}
            </tbody>
        </table>
        </div>
    )
}

export default OutsourcingMainTable;