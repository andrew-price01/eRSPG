$(function() {
    fetchProposals();
});

const tableBuilder = (proposalList) => {
    const tableBodyElm = $('tbody');
    if (jQuery.isArray(proposalList)) {
        proposalList.map((p) => {
           tableBodyElm.append(`
            <tr>
                <td data-label="Title">${p.name}</td>
                <td data-label="Submitter">${p.user}</td>
                <td data-label="Project Director">${p.director}</td>
                <td data-label="Department">${p.department}</td>
                <td data-label="Proposal Year">${p.year}</td>
                <td data-label="Submission Date">${new Date(p.submitDate).toLocaleDateString('en-US',{
                    year: '2-digit',
                    month: '2-digit',
                    day: '2-digit',
                    hour: '2-digit',
                    minute: '2-digit',
                    hour12: true,
                })}</td>
                <td data-label="Status">${p.status}</td>
            </tr>
           `);
       });
   }
};
//                <td data-label="Submission Date">${moment().format("MM/DD/YYYY hh:mm A",p.submitDate)}</td>

const fetchProposals = () => {
    jQuery.ajax({
        dataType: 'json',
        url: '/eRSPG/proposal/',
        success: (data) => {
            console.log('success!');
            tableBuilder(data);
        },
        error: function() {
            console.error('error!');
        },
    });
};
