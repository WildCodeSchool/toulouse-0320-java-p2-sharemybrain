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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `id_answer` int(11) NOT NULL AUTO_INCREMENT,
  `id_question` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `description` text NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_answer`),
  KEY `answer_question_FK` (`id_question`),
  KEY `answer_user0_FK` (`id_user`),
  CONSTRAINT `answer_question_FK` FOREIGN KEY (`id_question`) REFERENCES `question` (`id_question`),
  CONSTRAINT `answer_user0_FK` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (12,15,22,'It depends on whether you want to keep an empty spot or not.  If you do want an empty slot, delete is fine:  delete array[index]; If you don\'t, you should use the splice method:  array.splice(index, 1);','2020-05-14'),(13,16,22,'Sometimes the old ways are the best:  var index; var a = [\"a\", \"b\", \"c\"]; for (index = 0; index < a.length; ++index) {     console.log(a[index]); }','2020-05-14'),(14,17,23,'Assuming you\'re joining on columns with no duplicates, which is a very common case:  An inner join of A and B gives the result of A intersect B, i.e. the inner part of a Venn diagram intersection.  An outer join of A and B gives the results of A union B, i.e. the outer parts of a Venn diagram union.','2020-05-14'),(15,18,20,'You can quickly review the changes made to a file using the diff command:  git diff <commit hash> <filename> Then to revert a specific file to that commit use the reset command:  git reset <commit hash> <filename>','2020-05-14'),(16,25,3,'You are using a array as an object, the difference between getElementbyId and getElementsByClassName is that:  getElementbyId will return an Element object or null if no element with the ID is found getElementsByClassName will return a live HTMLCollection, possibly of length 0 if no matching elements are found','2020-05-14'),(17,29,3,'With jQuery, you can shallow copy with extend:  var copiedObject = jQuery.extend({}, originalObject) subsequent changes to the copiedObject will not affect the originalObject, and vice versa.  Or to make a deep copy:  var copiedObject = jQuery.extend(true, {}, originalObject)','2020-05-14'),(18,33,3,'You can use splice to do the same. Syntax = array.splice(start_index, no_of_elements) Following is the command:  fruits.splice(2, 1) This will remove one element from index 2, i.e. after the operation fruits=[\"mango\",\"apple\",\"berry\"];','2020-05-14'),(19,34,3,'I using the selector and I apply it on the document.  This binds itself on the document and will be applicable to the elements that will be rendered after page load.  For example:  $(document).on(\"click\", \'selector\', function() {     // Your code here });','2020-05-14'),(20,36,3,'A function in JavaScript is not just a reference to a set of instructions (as in C language), but it also includes a hidden data structure which is composed of references to all nonlocal variables it uses (captured variables). Such two-piece functions are called closures. Every function in JavaScript can be considered a closure.','2020-05-14'),(21,19,23,'An nvarchar column can store any Unicode data. A varchar column is restricted to an 8-bit codepage. Some people think that varchar should be used because it takes up less space. I believe this is not the correct answer. Codepage incompatabilities are a pain, and Unicode is the cure for codepage problems. With cheap disk and memory nowadays, there is really no reason to waste time mucking around with code pages anymore.','2020-05-14'),(22,24,20,'.gitignore will prevent untracked files from being added (without an add -f) to the set of files tracked by git, however git will continue to track any files that are already being tracked.  To stop tracking a file you need to remove it from the index. This can be achieved with this command.  git rm --cached <file','2020-05-14'),(23,20,16,'Very weird to set li as flex wrapper when you using rich-text-editor and plain text - WHY?... inline-elements Also affected from flexbox (And it does not make sense to add extra markup for rich-text -or- &nbsp).','2020-05-14'),(100,21,21,'  You need to apply the flex properties to the <ul>  ul {   display: flex;   flex-direction: row; <-- not needed as this is the default behavior   flex-wrap: wrap; }  Putting the properties on the <div> tells it to display the <ul> in flex, not <li>.','2020-05-15'),(101,22,21,'  I don’t think you can select the parent in CSS only.  But as you already seem to have an .active class, it would be easier to move that class to the li (instead of the a). That way you can access both the li and the a via CSS only.','2020-05-15'),(102,23,21,'This will be possible in the future with the CSS4 parent selector, but for now you would have to use JavaScript.','2020-05-15'),(200,26,20,'Working on your own and just want it to work? Follow these instructions below, they’ve worked reliably for me and many others for years.  Working with others? Git is complicated. Read the comments below this answer before you do something rash.  Reverting Working Copy to Most Recent Commit To revert to a previous commit, ignoring any changes:  git reset --hard HEAD','2020-05-15'),(201,29,24,'an object could be clone with a jquery extends','2020-05-15'),(202,28,25,'the null pointer can be caused by an array ','2020-05-15'),(203,34,26,'Using a selector with a jquery you can do it ','2020-05-15'),(204,31,27,'the difference is that we have the interface that can be ','2020-05-15'),(205,39,28,'INSERT INTO table (value1) VALUES (val)','2020-05-15');
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
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
