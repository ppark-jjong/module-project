import React, { useState } from "react";
import "../ListBox/UserIdSub.css";

const UserIdSub = () => {
    const UserIdSubListData = [
        { id:0 , name:"공장1"},
        { id:1 , name:"공장2"},
        { id:2 , name:"공장3"},
        { id:3 , name:"공장4"},
        { id:4 , name:"공장5"}
    ]

    const [selectedUserIdSub, setSelectedUserIdSub] = useState(null);

    const handleUserIdSubChange = (event) => {
        const selectedId = parseInt(event.target.value);
        const selectedUserIdSub = UserIdSubListData.find(UserIdSub => UserIdSub.id === selectedId);
        setSelectedUserIdSub(selectedUserIdSub);
    };

    return (
        <div className="UserIdSubListBox">
            <select value={selectedUserIdSub ? selectedUserIdSub.id : ''} onChange={handleUserIdSubChange} className="UserIdSubSelectBox">
                <option value="">계정</option>
                {UserIdSubListData.map(UserIdSub => (
                    <option key={UserIdSub.id} value={UserIdSub.id}>{UserIdSub.name}</option>
                ))}
            </select>   
        </div>
    )
}

export default UserIdSub;
