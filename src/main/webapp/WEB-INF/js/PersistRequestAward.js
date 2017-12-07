/**
 * Created by iNaS2 on 12/1/2017.
 */
function getRequestedAwardData() {
    $(function () {
        $.ajax({
            type: "GET",
            url: '/eRSPG/proposalAwardData',
            datatype: 'json',
            cache: false,
            success: (data) => {
                data.forEach(checkBoxes);
                updateProposalRequestAward();
            }
        })
        return false;
    });
}

function checkBoxes(boxName){
    $('#awardTypes'+boxName).prop('checked', true);
}


function updateProposalRequestAward() {
    $(function () {
        $.ajax({
            type: "POST",
            url: '/eRSPG/proposalAwardData',
            data: {
                'awardTypes1': $('#awardTypes1').val(),
                'awardTypes2': $('#awardTypes2').val(),
                'awardTypes3': $('#awardTypes3').val()

            },
            datatype: 'json',
            cache: false,
            success: (data) => {
                console.log($('#awardTypes3').val());
                console.log($('#awardTypes3').val())
            }
        })
        return false;
    });
}



$(function () {
    $('#awardTypes1').on("blur", updateProposalRequestAward);
    $('#awardTypes2').on("blur", updateProposalRequestAward);
    $('#awardTypes3').on("blur", updateProposalRequestAward);
  //  $('#projectTypeID1').on("blur", updateProposalRequestAward);
  //  $('#projectTypeID2').on("blur", updateProposalRequestAward);
  //  $('#projectTypeID3').on("blur", updateProposalRequestAward);
    $( document ).ready(function() {
        getRequestedAwardData();
    });
});