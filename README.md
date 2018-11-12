# Simple Budget
###### SB This is a Full-stack web application that uses APIs, MySQL database, Spring Boot, HTML/CSS/JS/JAVA, Bootstrap and is deployed online. Users can create an account, login, logout, post to the community to share ideas on how to budget better, view and search posts. Users will also be able to utilize the built-in budget calculator to attain more financial security while also looking for supplemental income.

## APIs

#### Twilio
  * Purpose:
    - Ability to send out email blasts to users that want to recive notification from there post that have signed up for an notificiation
    - https://www.twilio.com/docs/
    
#### General
* Home Page
    - [] `SignUp` Button
    - [] `Login` Button
    - [] `About SB` button to about us page
    - [] `Community/Post` to the community page
    - [] 3 most recent reiviews
    
    * _From the `SignUp` button..._
      - [] Fields for Username, Password, Email, phone, and...
      - [] Checks for existing usernames/emails to avoid duplication
      
###### The experience now branches off into two directions, depending on what the user is wanting, to use the budget app or go to the community
### Budget App
 * Account Info
    - [] Field for Saving / income
    - [] Supplemental income
    - [] My Post
    * Login
      - [] `Username` and `Password`
      - [] Verifies username exists
      - [] Verifies password matches
      - [] Forwards to `Profile`  
        *  Profile
          - [] Information about the user (username, email, phonenumber, post)
          - [] Stats about post/commments
          - [] `Notification` option, to notifiy of a reply to a thread
         * Dashboard
             - [] ~Ability to  edit current profile information~
             - [] Can see their own stats about post
             - [] ~Can see most recent post
             - [] Can update there budget savings/income informatrion
#### Community
  * Post
    -[] Be able to post to community
    -[] No one can hijack or edit others post or comments
    - [] Be able to reply to comments
    - [] Be able to upvote/downvote a comment
    -[] Be able to receive notification from selected thread
       
 ## Special
 #### ~Admin~ #
           * Registration 
           Be able to log in and moderate post/community.   