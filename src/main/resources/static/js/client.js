$(function () {
    var TOKEN_KEY = "jwtToken";
    var PERSONID_KEY = "personId";
    var $messageBox = $("#messageBox");
    var $login = $("#login");
    var $userInfo = $("#userInfo").hide();

   function getJwtToken() {
        return localStorage.getItem(TOKEN_KEY);
    }

    function setJwtToken(token) {
        localStorage.setItem(TOKEN_KEY, token);
    }

    function setPersonId(personId){
    	localStorage.setItem(PERSONID_KEY, personId);
    }
    
    function getPersonId(){
    	return localStorage.getItem(PERSONID_KEY);
    }
    
    function removeJwtToken() {
        localStorage.removeItem(TOKEN_KEY);
    }
	
	function removePersonId() {
        localStorage.removeItem(PERSONID_KEY);
    }

    function doLogin(loginData) {
    	$.ajax({
            url: "/login",
            type: "POST",
            data: JSON.stringify(loginData),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data, textStatus, response) {
                console.log(data);
                setJwtToken(data.token);
                $login.hide();
                $messageBox.hide();
                showUserInformation();
            },
            error: function (response, textStatus, errorThrown) {
                if (response.status === 401 ||response.status === 403) {
                    $messageBox.text("Authentication failed!: " + response.responseText );
					$messageBox.show();
                } else {
                    throw new Error("an unexpected error occured: " + errorThrown);
                }
            }
        });
    }

    function doLogout() {
        removeJwtToken();
		removePersonId();
        $login.show();
        $userInfo
            .hide()
            .find("#userInfoBody").empty();
		$userInfo.find("#welcomeUser").empty();
		$messageBox.text("Please Log in!");
		$messageBox.show();
    }

    function createAuthorizationTokenHeader() {
        var token = getJwtToken();
        if (token) {
            return {"Authorization": "Bearer " + token};
        } else {
            return {};
        }
    }

    function showUserInformation() {
        $.ajax({
            url: "/user",
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            headers: createAuthorizationTokenHeader(),
            success: function (data, textStatus, jqXHR) {
				console.log(data);
				var $welcomeUser = $userInfo.find("#welcomeUser");
				$welcomeUser.append($("<h3>").text("Welcome "+data.name+"!"));
				setPersonId(data.personId);
                $userInfo.show();
            }
        });
    }
	
	function showProfileInformation() {
        $.ajax({
            url: "/person/"+getPersonId(),
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            headers: createAuthorizationTokenHeader(),
            success: function (data, textStatus, response) {
				console.log(data);
				var $userInfoBody = $userInfo.find("#userInfoBody");
                $userInfoBody.append($("<div>").text("Name: " + data.firstname+" "+data.lastname));
                $userInfoBody.append($("<div>").text("Email: " + data.email));
				$userInfoBody.append($("<div>").text("Phone: " + data.phone));
                $userInfo.show();
            }
        });
    }


    $("#loginForm").submit(function (event) {
        event.preventDefault();

        var $form = $(this);
        var formData = {
            username: $form.find('input[name="username"]').val(),
            password: $form.find('input[name="password"]').val()
        };

        doLogin(formData);
    });

    $("#logoutButton").click(doLogout);
    $("#profileButton").click(showProfileInformation);

    if (getJwtToken()) {
        $login.hide();
        $messageBox.hide();
        showUserInformation();
    }
});
