import React, { useState } from "react";
import "../ListBox/UserIdMain.css";

const UserIdMain = () => {
    const UserIdMainListData = [
        { id:0 , name:"유저1"},
        { id:1 , name:"유저2"},
        { id:2 , name:"유저3"},
        { id:3 , name:"유저4"},
        { id:4 , name:"유저5"}
    ]

    const [selectedUserIdMain, setSelectedUserIdMain] = useState(null);

    const handleUserIdMainChange = (event) => {
        const selectedId = parseInt(event.target.value);
        const selectedUserIdMain = UserIdMainListData.find(UserIdMain => UserIdMain.id === selectedId);
        setSelectedUserIdMain(selectedUserIdMain);
    };

    return (
        <div className="UserIdListBox">
            <select value={selectedUserIdMain ? selectedUserIdMain.id : ''} onChange={handleUserIdMainChange} className="UserIdSelectBox">
                <option value="">계정</option>
                {UserIdMainListData.map(UserIdMain => (
                    <option key={UserIdMain.id} value={UserIdMain.id}>{UserIdMain.name}</option>
                ))}
            </select>   
        </div>
    )
}

export default UserIdMain;
