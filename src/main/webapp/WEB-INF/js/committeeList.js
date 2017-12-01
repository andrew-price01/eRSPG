$(function() {
    fetchCommittee();
});

const tableBuilder = (committeeList) => {
    const tableBodyElm = $('#members');
    if (jQuery.isArray(committeeList)) {
        committeeList.map((p) => {
            tableBodyElm.append(`
            <tr>
                <td data-label="First Name">${p.firstName}</td>
                <td data-label="Last Name">${p.lastName}</td>
                <td data-label="Email">${p.email}</td>
            </tr>
           `);
        });
    }
};

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

