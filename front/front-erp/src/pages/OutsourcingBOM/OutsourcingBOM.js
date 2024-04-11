import React, { useState } from "react";
import './OutsourcingBOM.css';
import FactoryListBox from "../../components/ListBox/FactoryListBox";
import ProcurementSelect from "../../components/ListBox/ProcurementSelect";
import UserIdMain from "../../components/ListBox/UserIdMain";
import UserIdSub from "../../components/ListBox/UserIdSub";
import OutsourcingMainTable from "../../components/OutsourcingMainTable";
import OutsourcingSubTable from "../../components/OutsourcingSubTable";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { faMagnifyingGlass } from "@fortawesome/free-solid-svg-icons";


const OutsourcingBOM = () => {
    const [productSearch, setProductSearch] = useState(""); //품목 검색어 상태

    const handleProductSearchChange = (event) => {
        setProductSearch(event.target.value); //입력된 검색어로 상태 업데이트
    }

    return (
        <div className="OutsourcingContainer">
            <div className="OutsourcingTitleBar">
                <img src="com-icon.png" className="ComIconPng" />
                <b className="OutsourcingTitleText">외주BOM</b>
                <div className="OutsourcingButtonGroup">
                    <button className="ExcelUploadBtn">
                        엑셀업로드
                    </button>
                    <button className="CreateBomBtn">
                        생성BOM
                    </button>
                    <button className="CopyBomBtn">
                        BOM복사
                    </button>
                </div>
            </div>
            <div className="SelectBoxGroup">
                <div className="SelectBoxGroup1">
                    <div className="FactoryContainer">
                        <div className="FactoryTitle">공장</div>
                        <FactoryListBox />
                    </div>
                    <div className="OutsourcingInputContainer">
                        <div className="OutsourcingTitle">외주처</div>
                        <input
                            className="OutsourcingInput"
                            type="text"
                            placeholder="외주처 입력"
                        />
                        <button type="button" id="OutsourcingSearchBtn">
                            <FontAwesomeIcon className="OutsourcingsearchBtnIcon" icon={faMagnifyingGlass}></FontAwesomeIcon>
                        </button>
                    </div>
                    <div className="ProductListContainer">
                        <div className="ProductListTitle">품목</div>
                        <input
                            className="ProductListInput"
                            type="text"
                            placeholder="품목 입력"
                            value={productSearch} // 품목 검색어 상태와 연결
                            onChange={handleProductSearchChange} // 입력값 변경 핸들러
                        />
                        <button type="button" id="ProductListSearchBtn">
                            <FontAwesomeIcon className="ProductListsearchBtnIcon" icon={faMagnifyingGlass}></FontAwesomeIcon>
                        </button>
                    </div>
                </div>
                <div className="SelectBoxGroup2">
                    <div className="ProcurementContainer">
                        <div className="ProcurementTitle">조달구분</div>
                        <ProcurementSelect />
                    </div>
                    <div className="UserIdContainer">
                        <div className="UserIdTitle">계정구분</div>
                        <UserIdMain />
                        <UserIdSub />
                    </div>
                </div>
            </div>
            <OutsourcingMainTable productSearch={productSearch}/> 
            <div className="AddDelBtnGroup">
                <button className="AddBtn">
                    추가
                </button>
                <button className="DeleteBtn">
                    삭제
                </button>
            </div>
            <OutsourcingSubTable />
        </div>
    )
}

export default OutsourcingBOM;