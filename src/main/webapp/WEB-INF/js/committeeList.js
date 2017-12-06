$(function() {
    fetchCommittee();
    fetchEmails();
});

function autoComplete(list) {
    var arr = $.map(list, function(el) { return JSON.parse(JSON.stringify(el.email)) });
    // console.log(JSON.stringify(arr[0]));
    $("#searchEmail").autocomplete({source: arr});
}

function addMemberDialog() {
    $('#dialogTabForm').dialog({
        resizable: false,
        draggable: true,
        show: 'fade',
        hide: 'fade',
        modal: true,
        width: 450,
        open: function (event, ui) {
            $('#dialogTabForm').css('overflow', 'hidden');
            jQuery('.ui-widget-overlay').bind('click',function(){
                jQuery('#dialogTabForm').dialog('close');
            })
        },
        create: function() {
            $('#tabs').tabs();
        },
        buttons:{
            Add:function () {
                // returns 0(tab1) or 1(tab2)
                var active = $( ".tabs" ).tabs( "option", "active" );

                if (active == 0) {
                    var email = document.getElementById("searchEmail").value;
                    addNewMember(document.getElementById("searchEmail").value);
                    {$(this).dialog("close");}
                    location.reload();
                }
                else if (active == 1) {
                    alert("tab2");
                }
            },
            Cancel:function () {$(this).dialog("close");}
        }
    });

    $('#OpenDialog').click(function() {
        $('#dialog-movie-info').dialog('open');
    });
}

const tableBuilder = (committeeList) => {
    const tableBodyElm = $('#members');
    if (jQuery.isArray(committeeList)) {
        committeeList.map((p) => {
            tableBodyElm.append(`
            <tr>
                <td data-label="First Name">${p.firstName}</td>
                <td data-label="Last Name" class="last">${p.lastName}</td>
                <td data-label="Email">${p.email}</td>
                <td data-label="Manage">
                    <input type="button" value="Edit" onclick="openDialog('${p.firstName}', '${p.lastName}', '${p.email}', '${p.id}');" />
                    <input type="button" value="Remove" onclick="confirmDelete('${p.id}');" />
                </td>
            </tr>
           `);
        });
    }
};

function openDialog(firstName, lastName, email, id) {
    var dialog, form,

        // From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
        emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
        firstName = $("#firstName").val(firstName),
        lastName = $("#lastName").val(lastName),
        email = $( "#email" ).val(email),
        id = id;
        allFields = $( [] ).add( firstName ).add( lastName ).add( email );

    dialog = $( "#dialog-form" ).dialog({
        autoOpen: false,
        height: 400,
        width: 400,
        draggable: true,
        modal: true,
        open: function (event, ui) {
            $('#dialog-form').css('overflow', 'hidden');
            jQuery('.ui-widget-overlay').bind('click', function() {
                jQuery("#dialog-form").dialog("close");
            })
        },
        buttons: {
            "Save": function() {
                saveEdit(id, document.getElementById("firstName").value, document.getElementById("lastName").value, document.getElementById("email").value);

                dialog.dialog("close");
                location.reload();
            },
            Cancel: function() {
                dialog.dialog( "close" );
            }
        },
        close: function() {
            /*form[ 0 ].reset();
            allFields.removeClass( "ui-state-error" );*/
            dialog.dialog( "close" );
        }
    });

    form = dialog.find( "form" ).on( "submit", function( event ) {
        event.preventDefault();
    });

    dialog.dialog( "open" );

};

function saveEdit(id, firstname, lastname, email) {
    var data = {
        userRoleId : id,
        firstName : firstname,
        lastName : lastname,
        email : email
    };

    jQuery.ajax({
        url: '/eRSPG/chairman/editcommittee',
        type:"POST",
        data: data,
        success: function(response){
            console.log('success!');
        },
        error: function(xhr, status, error) {
            // console.error('Exeption:' + exception);
            alert(xhr.responseText);
        },
    });
}

function confirmDelete(user_id) {

    var data = {
        userId : user_id
    };
    if(confirm("Are you sure you want to remove this member from the committee?"))
    {
        jQuery.ajax({
            url: '/eRSPG/chairman/committee',
            type:"POST",
            data: data,
            success: function(response){
                console.log('confirmDelete success!');
                location.reload();
            },
            error: function() {
                console.error('confirmDelete error!');
            },
        });
    }else{
        console.log(data);
        return false;
    }
    return true;
}

function addNewMember(email) {
    var e = { fEmail : email };

    jQuery.ajax({
        url: '/eRSPG/chairman/addcommittee',
        type:"POST",
        data: e,
        success: function(response) {
            console.log("success");
        },
        error: function(exception) {
            console.error('Exeption:' + exception);
        },

    });
}

const fetchCommittee = () => {
    jQuery.ajax({
        dataType: 'json',
        url: '/eRSPG/committeemembers',
        success: (data) => {
            console.log(' fetchCommittee success!');
            tableBuilder(data);
        },
        error: function() {
            console.error('fetchCommittee error!');
        },
    });
};

const fetchEmails = () => {
    jQuery.ajax({
        dataType: 'json',
        url: '/eRSPG/emaillist',
        success: (data) => {
            console.log('fetchEmails success!');
            autoComplete(data);
        },
        error: function() {
            console.error('fetchEmails error!');
        },
    });
};
