-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: gogodb
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Admin','administrate everything'),
(2,'Salesperson','handle activities related to sales,price, customers,orders and sales report'),
(3,'Editor','Edit articles,brands, products'),(4,'Shipper','ship products and update order status'),
(5,'Assistant','assist questions and reviews'),
(6,'manager','manage teams sales, shippers, editors');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES 
(1,'andy.davis@gmail.com',1,'Andy','Davis','$2a$10$bDqskP9Z/y6BIZnFLgJ8HuwMYaZXD9w2jVk2pYHXgn1k6N4nckleu','Andy Davis.png'),
(2,'angela.price@gmail.com',1,'Angela','Price','$2a$10$zRa/rmQ8JarpYG2bNKftyelKnsUhsHwGB.xmCKTWJClsB7O9wzTnG','Angela Price.png'),
(3,'david.wallace@gmail.com',0,'David','Wallace','$2a$10$GINThwCjVZAbGnmOe9BIeuDuvDlyfuwZrg/Rsmrjs1Lsq2pnXtO/S','David Wallace.png'),
(4,'george.cloney@gmail.com',1,'George','Cloney','$2a$10$UcHWHC72azPVZJb5Ky.Yy.X695WGf1ZkkGMS3WL3B9WqWf2dQD04G','George Cloney.jpg'),
(5,'james.carey@gmail.com',1,'James','Carey','$2a$10$YHXRsZ07/Btv.qCgGht.7u2PW.GLWzpVB7eabfgH1mhTVVXffDT6K','James Carey.png'),
(6,'jimmy.bruce@gmail.com',0,'Jimmy','Bruce','$2a$10$1jl3q3r/Fh9ZBv6ziM4XhuxCi2GMFWcfHUrxsesXAEwnsiV/NJKbq','Jimmy Bruce.jpg'),
(7,'kelly.preston@gmail.com',1,'Kelly','Preston','$2a$10$WyHmQiXCSYuHcGeg8eFWvOScqzSgg88MmqpajPdzSkLsvZjT3tKC.','Kelly Preston.png'),
(8,'meredith.palmer@gmail.com',1,'Meredith','Palmer','$2a$10$N1eE87eXFB2XQ5nmWKaTXOofnrPn8koeNvZhEpleJzO49i55e/Vk.','Meredith Palmer.png'),
(9,'pam.bondi@hotmail.com',1,'Pam','Bondi','$2a$10$3sH0v..zpjwA8ux5/q.OAeu0HgmSdMj8VzMWzhwwBDkE8wOISsUyi','Pam Bondi.png'),
(10,'phyllis.murphy@gmail.com',1,'Phyllis','Murphy','$2a$10$KXHmKpE6YB/0sjiy3fkMv.muKyxqvOXE6jVeaPu8KEaExx62ZmmNe','Phyllis Murphy.png'),
(11,'patrick.roy@mail.com',1,'Patrick','Roy','$2a$10$sz0CHOHAY1Xjt2ajIZgnG.L2KBQ4SsQkOGsPYue.C5gr6j.KMDdqS','Roy Patrick.png'),
(12,'toby.jones@hotmail.com',0,'Toby','Jones','$2a$10$R7EJcaYijjJo/IVk6c1CieBML2uP3RAKMVlCxylPAePlCfJsX7OOy','Toby Jones.png');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(2,1),(3,2),(4,5),(5,2),(6,2),(7,3),(8,6),(9,2),(10,2),(11,3),(12,3);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-26  6:33:57
