# Simple Budget
###### SB This is a Full-stack web application that uses APIs, MySQL database, Spring Boot, HTML/CSS/JS/JAVA, Bootstrap and is deployed online. Users can create an account, login, logout, post to the community to share ideas on how to budget better, view and search posts. Users will also be able to utilize the built-in budget calculator to attain more financial security while also looking for supplemental income.

## APIs

#### Twilio
  * Purpose:
    - Ability to send out email blasts to users that want to recive notification from there post that have signed up for an notificiation
    - https://www.twilio.com/docs/
#### Google Charts
   * Purpose:
   - Ability to user pie charts to display a more visual appealing budget model  
   - https://developers.google.com/chart/
    
#### General
* Home Page
    - [x] `SignUp` Button
    - [x] `Login` Button
    - [x] `About SB` button to about us page
    - [x] `Community/Post` to the community page
    - [] see reviews
    
    * _From the `SignUp` button..._
      - [x] Fields for Username, Password, Email, phone, and...
      - [x] Checks for existing usernames/emails to avoid duplication
      
###### The experience now branches off into two directions, depending on what the user is wanting, to use the budget app or go to the community
### Budget App
 * Account Info
    - [] Field for Saving / income
    - [] Supplemental income
    * Login
      - [x] `Username` and `Password`
      - [x] Verifies username exists
      - [x] Verifies password matches
      - [x] Forwards to `Profile`  
        *  Profile
          - [x] Information about the user (username, email, phonenumber, post)
          - [x] `Notification` option, enter phone number for notifications
         * Dashboard
             - [x] ~Ability to  edit current profile information
             - [x] Can update there budget savings/income information
#### Community
  * Post
    -[x] Be able to post to community
    -[x] No one can hijack or edit others post or comments
    -[x] Be able to reply to comments
#### Reviews
 * Reviews
 -[x] Be able to post a review and view review
 -[x] Be able to update/edit a review
 -[x] limit 1 review per user
 
 
  
