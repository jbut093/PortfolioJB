window.addEventListener('load', function () {
    // If the URL path is /signup, fetchUsernames and checkPasswords
    if (window.location.pathname === '/signup') {
        fetchUsernames();
        checkPasswords();
    }

    // Fetch a JSON of usernames already registered
    // Then initialise the checkUniqueness function with allUsers passed through
    async function fetchUsernames() {
        const response = await fetch('/retrieveAllUsers');
        const allUsers = await response.json();
        checkUniqueness(allUsers);
    }

    // On each key press, a for loop is looped through the list of usernames retrieved and if there is a match
    // Then the user is alerted that their username is not unique
    function checkUniqueness(allUsers) {
        const enteredUsername = document.querySelector('#userName');
        const displayError = document.querySelector('#displayError');

        enteredUsername.addEventListener('keyup', function () {
            for (let i = 0; i < allUsers.length; i++) {
                const element = allUsers[i];
                // Convert username fetched to lowercase,
                if (
                    element.username.toLowerCase() ===
                    enteredUsername.value.toLowerCase()
                ) {
                    displayError.innerHTML = ` - Not unique`;
                    break;
                } else {
                    displayError.innerHTML = ``;
                }
            }
        });
    }

    function checkPasswords() {
        const firstPassword = document.querySelector('#psw');
        const secondPassword = document.querySelector('#psw-repeat');

        secondPassword.addEventListener('keyup', function () {
            // If a value has been entered in both the first and second password form, then comparePasswordFields
            if (
                firstPassword.value.length !== 0 &&
                secondPassword.value.length > 0
            ) {
                comparePasswordFields();
            }
        });
    }

    function comparePasswordFields() {
        const firstPassword = document.querySelector('#psw');
        const secondPassword = document.querySelector('#psw-repeat');
        const passwordError = document.querySelector('#passwordError');

        // If the value of the first and second passwords are not the same, alert that the passwords do not match
        if (firstPassword.value === secondPassword.value) {
            passwordError.innerHTML = ``;
            document.querySelector('.registerbtn').disabled = false;
        } else {
            passwordError.innerHTML = ` - Passwords do not match!`;
            document.querySelector('.registerbtn').disabled = true;
        }
    }

         if (window.location.pathname === '/') {
             document
                 .querySelector('#summer')
                 .classList.toggle('seasons-selected');
         }

     if (window.location.pathname === '/retrievePlants/Summer') {
         document.querySelector('#summer').classList.toggle('seasons-selected');
     }

     if (window.location.pathname === '/retrievePlants/Spring') {
         document.querySelector('#spring').classList.toggle('seasons-selected');
     }

     if (window.location.pathname === '/retrievePlants/Autumn') {
         document.querySelector('#autumn').classList.toggle('seasons-selected');
     }

     if (window.location.pathname === '/retrievePlants/Winter') {
         document.querySelector('#winter').classList.toggle('seasons-selected');
     }
});
