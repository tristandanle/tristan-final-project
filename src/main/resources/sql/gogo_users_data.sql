INSERT INTO `roles` VALUES (1,'Admin','manage everything'),
(2,'Editor','verify products and write publication'),
(3,'Director','Monitor progress toward achieving objectives and policies'),
(4,'Shipper','ship products and update order status'),
(5,'Manager','Accomplish department objectif by managing staffs'),
(6,'Customerservice','Answering questions about a company products or services');

UNLOCK TABLES;



LOCK TABLES `users` WRITE;

INSERT INTO `users` VALUES 
(1,'andy.davis@gmail.com',1,'Andy','Davis','$2a$10$OVi4hWafttA7FIopf/XNqOmgPd/MmgG9q1oBQLVzlIIS5zciRZONW','Andy Davis.png'),
(2,'angela.price@gmail.com',1,'Angela','Price','$2a$10$yVnOKvPMu7wezxw0WTMCG.8LioSAL4rTC.pU5UyfbsAu1kYeYrm3.','Angela Price.png'),
(3,'george.cloney@gmail.com',1,'George','Cloney','$2a$10$zMjHAqhYs5vM.7akgBdrpuAvA.gaJ4/N3/qe2Omi5XAat1TKKj/H2','George Cloney.jpg'),
(4,'james.carey@gmail.com',1,'James','Carey','$2a$10$dwv34zfrFMGaJBJFOIS.qeO0Lf1y2FB/65ELAuy8RkZxaW0mNMGDq','James Carey.png'),
(5,'jimmy.bruce@gmail.com',0,'Jimmy','Bruce','$2a$10$fKKJZAiMfFCGzGHfXleGg.J1eDtGtdowx0OnvfD8Y/E63GLp25N.i','Jimmy Bruce.jpg'),
(6,'kelly.preston@gmail.com',1,'Kelly','Preston','$2a$10$JuFMoMUSjjskmqYHxGiJWO2gzTklPencwiJm7OG/VM0opwmRfruOe','Kelly Preston.png'),
(7,'phyllis.murphy@gmail.com',1,'Phyllis','Murphy','$2a$10$sZpwfVPhLY4lZEkbqq6KGuOKa7Vch3XKcw9WlGmAiDgdDKfJ6a1YW','Phyllis Murphy.png'),
(8,'toby.jones@hotmail.com',0,'Toby','Jones','$2a$10$.58P8PUqagmJsAXEJkLcxOVQyvCkH61Mu8bTVLWgh1fSP7q0wsSvq','Toby Jones.png');

UNLOCK TABLES;

LOCK TABLES `users_roles` WRITE;

INSERT INTO `users_roles` VALUES (1,1),(2,1),(3,2),(4,5),(5,2),(6,2),(7,3),(8,6);

UNLOCK TABLES;