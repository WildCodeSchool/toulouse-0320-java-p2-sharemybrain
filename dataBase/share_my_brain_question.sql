-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: localhost    Database: share_my_brain
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id_question` int(11) NOT NULL AUTO_INCREMENT,
  `title` text NOT NULL,
  `description` text NOT NULL,
  `date` date NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_skill` int(11) NOT NULL,
  PRIMARY KEY (`id_question`),
  KEY `question_user_FK` (`id_user`),
  KEY `question_skill0_FK` (`id_skill`),
  CONSTRAINT `question_skill0_FK` FOREIGN KEY (`id_skill`) REFERENCES `skill` (`id_skill`),
  CONSTRAINT `question_user_FK` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (15,'How can I remove a specific item from an array?','I have an array of numbers, and I\'m using the .push() method to add elements to it.  Is there a simple way to remove a specific element from an array?  The equivalent of something like -  array.remove(number); I have to use core JavaScript - frameworks are not allowed.','2020-03-14',3,4),(16,'For-each over an array in JavaScript','How can I loop through all the entries in an array using JavaScript?  I thought it was something like this:  forEach(instance in theArray) Where theArray is my array, but this seems to be incorrect.','2020-05-02',7,4),(17,'What is the difference between “INNER JOIN” and “OUTER JOIN”?','Also how do LEFT JOIN, RIGHT JOIN and FULL JOIN fit in?','2020-01-12',8,5),(18,'How can I reset or revert a file to a specific revision?','I have made some changes to a file which has been committed a few times as part of a group of files, but now want to reset/revert the changes on it back to a previous version.  I have done a git log along with a git diff to find the revision I need, but just have no idea how to get the file back to its former state in the past.','2020-05-14',16,6),(19,'What is the difference between varchar and nvarchar?','Is it just that nvarchar supports multibyte characters? If that is the case, is there really any point, other than storage concerns, to using varchars?','2019-12-14',17,5),(20,'display: flex breaks <li> element with Text and HTML-Tags like <strong> inside [duplicate]','This question already has answers here: Removing display:flex adds spaces around a link. Why? (1 answer) Why does a ::before pseudoelement with content have only leading spaces stripped in a \'display: flex\' container? (1 answer) What do “flex” and “justify-content” achieve that “text-align” doesn\'t? (3 answers) Closed 3 hours ago. I\'am currently running into a problem with display: flex when using it on a <li> Element with Text and HTML-Tags like <strong>, <b>, <i>, <u> and so on. display: flex is used to position the custom bullet points to the text and to hide the default bullet points with overwrite the default display: list-item with display: flex.','2020-02-14',18,1),(21,'Flexbox with Unordered list','I am trying to learn flexbox and I really like it. I am trying play with dynamic widths and when I do it with divs it works. If I try to do it with li, it does not work as well. ','2020-01-25',19,2),(22,'Is there a CSS parent selector?','How do I select the <li> element that is a direct parent of the anchor element?','2019-12-02',20,2),(23,'Target body on Input:focus [duplicate]','Ive been looking around but have had no luck is it possible (with css) to target the body tag on input:focus so for example when someone clicks on the input box i want the body to have background:red, im not sure if this is actually possible.  Thanks in advance.','2019-11-21',21,2),(24,'How to make Git “forget” about a file that was tracked but is now in .gitignore?','There is a file that was being tracked by git, but now the file is on the .gitignore list.  However, that file keeps showing up in git status after it\'s edited. How do you force git to completely forget about it?','2020-05-03',22,6),(25,'What do querySelectorAll and getElementsBy* methods return?','Do getElementsByClassName (and similar functions like getElementsByTagName and querySelectorAll) work the same as getElementById or do they return an array of elements?  The reason I ask is because I am trying to change the style of all elements using getElementsByClassName. See below.','2020-01-24',23,4),(26,'How do I revert a Git repository to a previous commit?','This question\'s answers are a community effort. Edit existing answers to improve this post. It is not currently accepting new answers or interactions. How do I revert from my current state to a snapshot made on a certain commit?','2019-11-18',3,6),(28,'What is a NullPointerException, and how do I fix it?','What are Null Pointer Exceptions (java.lang.NullPointerException) and what causes them?  What methods/tools can be used to determine the cause so that you stop the exception from causing the program to terminate prematurely?','2020-04-23',7,3),(29,'How do I correctly clone a JavaScript object?','I have an object x. I\'d like to copy it as object y, such that changes to y do not modify x. I realized that copying objects derived from built-in JavaScript objects will result in extra, unwanted properties. This isn\'t a problem, since I\'m copying one of my own literal-constructed objects.  How do I correctly clone a JavaScript object?','2020-05-12',8,4),(30,'What\'s the simplest way to print a Java array?','In Java, arrays don\'t override toString(), so if you try to print one directly, you get the className + \'@\' + the hex of the hashCode of the array, as defined by Object.toString()','2020-05-10',16,3),(31,'What is the difference between an interface and abstract class?','What exactly is the difference between an interface and abstract class?','2020-05-14',17,3),(32,'Can we instantiate an abstract class?','During one of my interview, I was asked \"If we can instantiate an abstract class?\"  My reply was \"No. we can\'t\". But, interviewer told me \"Wrong, we can.\"  I argued a bit on this. Then he told me to try this myself at home.','2020-02-23',18,3),(33,'How can I remove an array element by index, using javaScript?','fruits = [\"mango\",\"apple\",\"pine\",\"berry\"]; If I want to remove an element index wise, How to do that using JavaScript. Also you can use library as required.','2020-02-15',19,4),(34,'Event binding on dynamically created elements?','I have a bit of code where I am looping through all the select boxes on a page and binding a .hover event to them to do a bit of twiddling with their width on mouse on/off.  This happens on page ready and works just fine.  The problem I have is that any select boxes I add via Ajax or DOM after the initial loop won\'t have the event bound.  I have found this plugin (jQuery Live Query Plugin), but before I add another 5k to my pages with a plugin, I want to see if anyone knows a way to do this, either with jQuery directly or by another option.','2020-05-14',20,4),(35,'How to create GUID / UUID?','I\'m trying to create globally-unique identifiers in JavaScript. I\'m not sure what routines are available on all browsers, how \"random\" and seeded the built-in random number generator is, etc.  The GUID / UUID should be at least 32 characters and should stay in the ASCII range to avoid trouble when passing them around.','2020-05-14',21,4),(36,'How do JavaScript closures work?','How would you explain JavaScript closures to someone with a knowledge of the concepts they consist of (for example functions, variables and the like), but does not understand closures themselves?','2020-05-14',22,4),(37,'Difference between static class and singleton pattern?','What real (i.e. practical) difference exists between a static class and a singleton pattern?  Both can be invoked without instantiation, both provide only one \"Instance\" and neither of them is thread-safe. Is there any other difference?','2020-05-14',23,3),(38,'how can I create an array ','I would like to know how to create an array on javascript','2020-05-15',24,4),(39,'how to insert a new element','how can insert a new element in a SQL table','2020-05-15',25,5),(40,'how to make a function?','how can i create an anonymous founction in javascript','2020-05-15',26,4),(41,'accessing an array','how is possible to access an element of an array','2020-05-15',27,3),(42,'Delete an item ','How can i delete an item ','2020-05-15',28,5);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-26 17:50:37
