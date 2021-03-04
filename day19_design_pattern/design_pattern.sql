-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 03, 2019 at 01:16 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `codecamp2`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `id` int(11) NOT NULL,
  `name` varchar(60) NOT NULL,
  `detail` varchar(255) NOT NULL DEFAULT '',
  `price` int(11) NOT NULL,
  `teach_by` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `name`, `detail`, `price`, `teach_by`, `created_at`) VALUES
(1, 'Cooking', '', 90, 23, '2019-03-26 15:12:56'),
(2, 'Acting', '', 90, 23, '2019-03-26 15:12:56'),
(3, 'Chess', '', 90, 22, '2019-03-26 15:12:56'),
(4, 'Writing', '', 90, 21, '2019-03-26 15:12:56'),
(5, 'Conservation', '', 90, 20, '2019-03-26 15:12:56'),
(6, 'Tennis', '', 90, 19, '2019-03-26 15:12:56'),
(7, 'The Art of Performance', '', 90, 18, '2019-03-26 15:12:56'),
(8, 'Writing #2', '', 90, 17, '2019-03-26 15:12:56'),
(9, 'Building a Fashion Brand', '', 90, 16, '2019-03-26 15:12:56'),
(10, 'Design and Architecture', '', 90, 15, '2019-03-26 15:12:56'),
(11, 'Singing', '', 90, 14, '2019-03-26 15:12:56'),
(12, 'Jazz', '', 90, 13, '2019-03-26 15:12:56'),
(13, 'Country Music', '', 90, 12, '2019-03-26 15:12:56'),
(14, 'Fashion Design', '', 90, 11, '2019-03-26 15:12:56'),
(15, 'Film Scoring', '', 90, 10, '2019-03-26 15:12:56'),
(16, 'Comedy', '', 90, 9, '2019-03-26 15:12:56'),
(17, 'Writing for Television', '', 90, 8, '2019-03-26 15:12:56'),
(18, 'Filmmaking', '', 90, 7, '2019-03-26 15:12:56'),
(19, 'Dramatic Writing', '', 90, 6, '2019-03-26 15:12:56'),
(20, 'Screenwriting', '', 90, 5, '2019-03-26 15:12:56'),
(21, 'Electronic Music Production', '', 90, 4, '2019-03-26 15:12:56'),
(22, 'Cooking #2', '', 90, 3, '2019-03-26 15:12:56'),
(23, 'Shooting, Ball Handler, and Scoring', '', 90, 2, '2019-03-26 15:12:56'),
(24, 'Photography', '', 90, 1, '2019-03-26 15:12:56'),
(25, 'Database System Concept', '', 30, NULL, '2019-03-26 15:12:56'),
(26, 'JavaScript for Beginner', '', 20, NULL, '2019-03-26 15:12:56'),
(27, 'OWASP Top 10', '', 75, NULL, '2019-03-26 15:12:56');

-- --------------------------------------------------------

--
-- Table structure for table `employee_users`
--

CREATE TABLE `employee_users` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `salary` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `company` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `employee_users`
--

INSERT INTO `employee_users` (`id`, `firstname`, `lastname`, `salary`, `username`, `password`, `company`) VALUES
(1001, 'Dang', 'Red', 10000, 'dang', 'dang_password', 'Waltz Disney'),
(1002, 'Dang2', 'Red2', 10000, 'dang2', '222', 'company'),
(1003, 'Dang3', 'Red3', 10000, 'dang3', '333', 'company');

-- --------------------------------------------------------

--
-- Table structure for table `instructors`
--

CREATE TABLE `instructors` (
  `id` int(11) NOT NULL,
  `name` varchar(60) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `instructors`
--

INSERT INTO `instructors` (`id`, `name`, `created_at`) VALUES
(1, 'Annie Leibovitz', '2019-03-26 15:12:56'),
(2, 'Stephen Curry', '2019-03-26 15:12:56'),
(3, 'Gordon Ramsay', '2019-03-26 15:12:56'),
(4, 'Deadmau5', '2019-03-26 15:12:56'),
(5, 'Aaron Sorkin', '2019-03-26 15:12:56'),
(6, 'David Mamet', '2019-03-26 15:12:56'),
(7, 'Werner Herzog', '2019-03-26 15:12:56'),
(8, 'Shonda Rhimes', '2019-03-26 15:12:56'),
(9, 'Steve Martin', '2019-03-26 15:12:56'),
(10, 'Hans Zimmer', '2019-03-26 15:12:56'),
(11, 'Marc Jacobs', '2019-03-26 15:12:56'),
(12, 'Reba Mcentire', '2019-03-26 15:12:56'),
(13, 'Herbie Hancock', '2019-03-26 15:12:56'),
(14, 'Christina Aguilera', '2019-03-26 15:12:56'),
(15, 'Frank Gehry', '2019-03-26 15:12:56'),
(16, 'Diane Von Furstenberg', '2019-03-26 15:12:56'),
(17, 'James Patterson', '2019-03-26 15:12:56'),
(18, 'Usher', '2019-03-26 15:12:56'),
(19, 'Serena Williams', '2019-03-26 15:12:56'),
(20, 'Dr. Jane Goodall', '2019-03-26 15:12:56'),
(21, 'Judy Blume', '2019-03-26 15:12:56'),
(22, 'Garry Kasparov', '2019-03-26 15:12:56'),
(23, 'Samuel L. Jackson', '2019-03-26 15:12:56'),
(24, 'Wolfgang Puck', '2019-03-26 15:12:56'),
(25, 'Martin Scorsese', '2019-03-26 15:12:56'),
(26, 'Bob Woofward', '2019-03-26 15:12:56'),
(27, 'Ron Howard', '2019-03-26 15:12:56'),
(28, 'Thomas Keller', '2019-03-26 15:12:56'),
(29, 'Alice Waters', '2019-03-26 15:12:56'),
(30, 'Helen Mirren', '2019-03-26 15:12:56'),
(31, 'Armin Van Buuren', '2019-03-26 15:12:56');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `courses_name_key` (`name`),
  ADD KEY `teach_by` (`teach_by`),
  ADD KEY `courses_created_at_desc` (`created_at`);

--
-- Indexes for table `employee_users`
--
ALTER TABLE `employee_users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `instructors`
--
ALTER TABLE `instructors`
  ADD PRIMARY KEY (`id`),
  ADD KEY `instructors_created_at_desc` (`created_at`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `employee_users`
--
ALTER TABLE `employee_users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1007;
--
-- AUTO_INCREMENT for table `instructors`
--
ALTER TABLE `instructors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `courses`
--
ALTER TABLE `courses`
  ADD CONSTRAINT `courses_ibfk_1` FOREIGN KEY (`teach_by`) REFERENCES `instructors` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
