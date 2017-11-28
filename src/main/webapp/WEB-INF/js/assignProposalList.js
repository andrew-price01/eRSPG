$(function() {
    fetchSubmittedProposals();
    fetchInReviewProposals();
});

const tableBuilder1 = (proposalList) => {
    const tableBodyElm = $("#submitted");
    if (jQuery.isArray(proposalList)) {
        proposalList.map((p) => {
            tableBodyElm.append(`
            <tr>
                <td data-label="Title">${p.name}</td>
                <td data-label="Submitter">${p.user}</td>
                <td data-label="Department">${p.department}</td>
                <td data-label="Proposal Year">${p.year}</td>
                <td data-label="Submission Date">${moment().format("MM/DD/YYY hh:mm A",p.submitDate)}</td>
                <td data-label="Status">${p.status}</td>
            </tr>
           `);
        });
    }
};

const fetchSubmittedProposals = () => {
    jQuery.ajax({
        dataType: 'json',
        url: '/eRSPG/submittedproposal/',
        success: (data) => {
            console.log('success!');
            tableBuilder1(data);
        },
        error: function() {
            console.error('error!');
        },
    });
};

const tableBuilder2 = (proposalList) => {
    const tableBodyElm = $("#review");
    if (jQuery.isArray(proposalList)) {
        proposalList.map((p) => {
            tableBodyElm.append(`
            <tr>
                <td data-label="Title">${p.name}</td>
                <td data-label="Submitter">${p.user}</td>
                <td data-label="Department">${p.department}</td>
                <td data-label="Proposal Year">${p.year}</td>
                <td data-label="Submission Date">${moment().format("MM/DD/YYY hh:mm A",p.submitDate)}</td>
                <td data-label="Status">${p.status}</td>
            </tr>
           `);
        });
    }
};

const fetchInReviewProposals = () => {
    jQuery.ajax({
        dataType: 'json',
        url: '/eRSPG/inreviewproposal/',
        success: (data) => {
            console.log('success!');
            tableBuilder2(data);
        },
        error: function() {
            console.error('error!');
        },
    });
};

