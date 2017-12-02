$(function() {
    fetchCommittee();
});

const tableBuilder = (committeeList) => {
    const tableBodyElm = $('#members');
    if (jQuery.isArray(committeeList)) {
        committeeList.map((p) => {
            tableBodyElm.append(`
            <tr>
                <td data-label="ID">${p.id}</td>
                <td data-label="First Name">${p.firstName}</td>
                <td data-label="Last Name">${p.lastName}</td>
                <td data-label="Email">${p.email}</td>
                <td data-label="Manage">
                    <a href="">Edit </a>
                    <input type="button" value="Delete" onclick="confirm_decision(${p.id});"
                </td>
            </tr>
           `);
        });
    }
};

const confirm_decision = (user_id) => {

    var data = {
        userId : user_id
    }
    if(confirm("Are you sure you want to remove this member from the committee?")) // this will pop up confirmation box and if yes is clicked it call servlet else return to page
    {
        jQuery.ajax({
            url: '/eRSPG/chairman/committee',
            type:"POST",
            data: data,
            success: function(response){
                console.log('success!');
            },
        });
    }else{
        return false;
    }
    return true;
}

const fetchCommittee = () => {
    jQuery.ajax({
        dataType: 'json',
        url: '/eRSPG/committeemembers',
        success: (data) => {
            console.log('success!');
            tableBuilder(data);
        },
        error: function() {
            console.error('error!');
        },
    });
};

