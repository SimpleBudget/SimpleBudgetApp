INSERT INTO users (id,email, password, phonenumber, username) VALUES (1,'britt@britt.com', '$2a$10$VVwX4Ak9QnvAYAuyMCxYN.WsvJM2g.bYqhKqhTwxV/3in2bOl8wqW', '2105555555', 'Britt'),(2,'hunter@hunter.com', '$2a$10$VVwX4Ak9QnvAYAuyMCxYN.WsvJM2g.bYqhKqhTwxV/3in2bOl8wqW', '510555555', 'Hunter'),(3,'patrick@patrick.com', '$2a$10$VVwX4Ak9QnvAYAuyMCxYN.WsvJM2g.bYqhKqhTwxV/3in2bOl8wqW', '+12146775272', 'Patrick'),(4,'lily@lily.com', '$2a$10$VVwX4Ak9QnvAYAuyMCxYN.WsvJM2g.bYqhKqhTwxV/3in2bOl8wqW', '5505555555', 'Lily'),(5,'will@will.com', '$2a$10$VVwX4Ak9QnvAYAuyMCxYN.WsvJM2g.bYqhKqhTwxV/3in2bOl8wqW', '5155555555', 'Will'),(6,'mike@mike.com', '$2a$10$VVwX4Ak9QnvAYAuyMCxYN.WsvJM2g.bYqhKqhTwxV/3in2bOl8wqW', '2555555555', 'Mike');

INSERT INTO accounts (id,user_id, income, choice) VALUES (1,1, '2000', '1'),(2,2, '4000', '1'),(3,3, '2200', '2'),(4,4, '4000', '2'),(5,5, '6000', '3'),(6,6, '40000', '3');

INSERT INTO bills (id,account_id, user_id, name, amount)VALUES (1,1, 1, 'Rent', '675'),(2,1, 1, 'Car', '150'),(3,1, 1, 'Phone', '45'),(4,1, 1, 'Insurance', '125'),(5,2, 2, 'Rent', '875'),(6,2, 2, 'Car', '200'),(7,2, 2, 'Phone', '75'),(8,2, 2, 'Insurance', '125'),(9,3, 3, 'Rent', '1000'),(10,3, 3, 'Car', '250'),(11,3, 3, 'Phone', '110'),(12,3, 3, 'Insurance', '125'),(13,4, 4, 'Rent', '1025');


INSERT INTO reviews (id,user_id, rating, body)VALUES (1,1, 5, 'I love using this app!'),(2,2, 5, 'Made budgeting myself so much easier'),(3,3, 5, 'I love being able to interact with others about budgeting.'),(4,4, 5, 'I would recommend this app to all my friends.'),(5,5, 5, 'Helped me save over $1,000 in less then a month!'),(6,6, 5, 'Best budgeting app I have ever used');


INSERT INTO posts (id, user_id, title, body)VALUES (1,1, 'Ideas for extra income', 'I need help coming up with ideas for extra income.'),(2,2, 'Stocks', 'Does anyone here know about investing in stocks?'),(3,3, 'I am willing to help', 'I will help people budget just connect here');

INSERT INTO comments (id,user_id, post_id, commentbody,comment_id)VALUES (1,3, 1, 'You could checkout the supplemental income page at the bottom of the page.',null),(2,1, 2, 'I do, what would you like to know?',null),(3,2, 3,  'I need some help!',null),(4,2,null,'Anything and everything!',2);

