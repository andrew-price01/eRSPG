/**
 * Created by iNaS2 on 12/1/2017.
 */
function updateProposalDetail() {
    $(function () {
            $.ajax({
                type: "POST",
                url: '/eRSPG/proposalDetailData',
                data: {
                    'title': $('#proposalTitle').val(),
                    'director': $('#projectDirector').val(),
                    'email': $('#proposalEmail').val(),
                    'mailCode': $('#proposalMailCode').val(),
                    'extension': $('#proposalExtension').val()
                },
                datatype: 'json',
                cache: false,
                success: (data) => {
                    console.log("Proposal detail updated")
                }
            })
            return false;
    });
}

$(function () {
    $('#proposalTitle').on("blur", updateProposalDetail);
    $('#projectDirector').on("blur", updateProposalDetail);
    $('#proposalEmail').on("blur", updateProposalDetail);
    $('#proposalMailCode').on("blur", updateProposalDetail);
    $('#proposalExtension').on("blur", updateProposalDetail);
});