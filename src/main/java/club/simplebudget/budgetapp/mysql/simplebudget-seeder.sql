
USE simplebudget_db;


INSERT INTO `users` (email, password, phonenumber, username)
      VALUES ('britt@britt.com', '$2a$10$VVwX4Ak9QnvAYAuyMCxYN.WsvJM2g.bYqhKqhTwxV/3in2bOl8wqW', '2105555555', 'Britt'),
             ('hunter@hunter.com', '$2a$10$VVwX4Ak9QnvAYAuyMCxYN.WsvJM2g.bYqhKqhTwxV/3in2bOl8wqW', '510555555', 'Hunter'),
             ('patrick@patrick.com', '$2a$10$VVwX4Ak9QnvAYAuyMCxYN.WsvJM2g.bYqhKqhTwxV/3in2bOl8wqW', '2146775272', 'Patrick'),
             ('lily@lily.com', '$2a$10$VVwX4Ak9QnvAYAuyMCxYN.WsvJM2g.bYqhKqhTwxV/3in2bOl8wqW', '5505555555', 'Lily'),
             ('will@will.com', '$2a$10$VVwX4Ak9QnvAYAuyMCxYN.WsvJM2g.bYqhKqhTwxV/3in2bOl8wqW', '5155555555', 'Will'),
             ('mike@mike.com', '$2a$10$VVwX4Ak9QnvAYAuyMCxYN.WsvJM2g.bYqhKqhTwxV/3in2bOl8wqW', '2555555555', 'Mike');

INSERT INTO `accounts` (user_id, income, choice)
      VALUES (1, '1000', '1'),
             (2, '890', '1'),
             (3, '1200', '2'),
             (4, '2000', '2'),
             (5, '6000', '3'),
             (6, '40000', '3');

INSERT INTO `bills` (account_id, user_id, name, amount)
      VALUES (1, 1, 'Rent', '675'),
             (1, 1, 'Car', '150'),
             (1, 1, 'Phone', '45'),
             (1, 1, 'Insurance', '125'),
             (2, 2, 'Rent', '875'),
             (2, 2, 'Car', '200'),
             (2, 2, 'Phone', '75'),
             (2, 2, 'Insurance', '125'),
             (3, 3, 'Rent', '1000'),
             (3, 3, 'Car', '250'),
             (3, 3, 'Phone', '110'),
             (3, 3, 'Insurance', '125'),
             (4, 4, 'Rent', '1025');


INSERT INTO `reviews` (user_id, rating, body)
      VALUES (1, 5, 'I love using this app!'),
             (2, 5, 'Made budgeting myself so much easier'),
             (3, 5, 'I love being able to interact with others about budgeting.'),
             (4, 5, 'I would recommend this app to all my friends.'),
             (5, 5, 'Helped me save over $1,000 in less then a month!'),
             (6, 5, 'Best budgeting app I have ever used');


INSERT INTO `posts` (user_id, title, body)
      VALUES (1, 'Ideas for extra income', 'I need help coming up with ideas for extra income.'),
              (2, 'Stocks', 'Does anyone here know about investing in stocks?'),
              (3, 'I am willing to help', 'I will help people budget just connect here');

INSERT INTO `comments` (user_id, post_id, commentbody)
      VALUES (3, 1, 'You could checkout the supplemental income page at the bottom of the page.'),
              (1, 2, 'I do, what would you like to know?'),
              (2, 3,  'I need some help!');

