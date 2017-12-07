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
                    $('#proposalTitle').val(data.title);
                    $('#projectDirector').val(data.director);
                    $('#proposalEmail').val(data.email);
                    $('#proposalMailCode').val(data.mailCode);
                    $('#proposalExtension').val(data.extension);
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