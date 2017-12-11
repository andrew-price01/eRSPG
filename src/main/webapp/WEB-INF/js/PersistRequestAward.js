/**
 * Created by iNaS2 on 12/1/2017.
 */
var checkboxesArray = [];

function manageArray() {
    checkboxesArray = [];
    let userSelection = $('input:checkbox');
    for(i=0;i<userSelection.length;i++){
        if(userSelection[i].checked){
            checkboxesArray.push(userSelection[i].value);
        }
    }
}

function getRequestedAwardData() {
    $(function () {
        $.ajax({
            type: "GET",
            url: '/eRSPG/getProposalAwardData',
            datatype: 'json',
            cache: false,
            success: (data) => {
                $('input:checkbox').prop('checked', false);

                let typeId = Object.keys(data)[0];
                $('input#projectTypeID'+typeId)[0].checked = true;
                data[typeId].forEach((selectedBoxValue) => {
                    $('input:checkbox')[parseInt(selectedBoxValue)-1].checked = true;
                })
                console.log("Award data loaded : SUCCESS");
            }
        })
        return false;
    });
}

function updateProposalRequestAward() {
    manageArray();
    $(function () {
        $.ajax({
            type: "POST",
            url: '/eRSPG/proposalAwardData',
            data: {
                'awards': checkboxesArray.toString(),
                'projectTypeID': parseInt($('input:radio[checked]')[0].value)
            },
            datatype: 'json',
            cache: false,
            success: () => {
            console.log("Request updated, Proposal updated : SUCCESS");
            }
        })
        return false;
    });
}

$( document ).ready(function() {
    $('input:checkbox').on("click", updateProposalRequestAward);
    getRequestedAwardData();
    $('input:radio').on("click", ()=>{this.checked = true; updateProposalRequestAward();});

});