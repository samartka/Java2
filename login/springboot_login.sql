-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2019 at 09:13 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `springboot_login`
--

-- --------------------------------------------------------

--
-- Table structure for table `app_role`
--

DROP TABLE IF EXISTS `app_role`;
CREATE TABLE `app_role` (
  `role_id` bigint(20) NOT NULL,
  `role_name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `app_role`
--

INSERT INTO `app_role` (`role_id`, `role_name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
CREATE TABLE `app_user` (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(36) COLLATE utf8_unicode_ci NOT NULL,
  `encrypted_password` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `firstname` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `lastname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `gender` enum('male','female') COLLATE utf8_unicode_ci DEFAULT NULL,
  `enabled` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `app_user`
--

INSERT INTO `app_user` (`user_id`, `user_name`, `encrypted_password`, `firstname`, `lastname`, `email`, `birth_date`, `gender`, `enabled`) VALUES
(1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'admin', 'admin2', 'aaaaa', NULL, NULL, b'1'),
(2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'aaa', 'bbb', 'c@c.com', NULL, 'female', b'1'),
(13, 'wt1akqf7d', '$2a$10$Ij4Pr3I8Ugsejvy6eOfPbO9Zzb.z5pmKas3I5/ZWu6L3r5bwbT43q', 'c', 'c', 'paiboonpa@gmail.com', '1980-01-01', 'male', b'1'),
(17, 'wt1akqf72', '$2a$10$9m6rtVczRGBF6MwOZIdSuuOhjPU2ydPb73E8wwhry03oc4.Fei8m6', 'd', 'd', 'paiboonpa@gmail.com', '1980-01-01', 'male', b'1'),
(18, 'dbuser2', '$2a$10$S.IjAbWSTuxs9Y2xKklICuN9GPDE/d6.usiHKyVoX88EmNxtNIoGK', 'e', 'e', 'a@a.com', '1980-01-01', 'male', b'1'),
(20, 'dbuser3', '$2a$10$Q1RvQk0vFboGhIBSH13xXuu5ZjoHeQcgLtNG9vI/RoM320env6UI.', 'f', 'f', 'paiboonpa@gmail.com', '1980-03-01', 'female', b'1'),
(21, 'wt1akqf7a', '$2a$10$eLTtR1FmmjXLss7B7.Mlk.oABwXnKCdNXJ5OZmm3SgOUk/sfk2XpW', 'g', 'g', 'paiboonpa@gmail.com', '1980-01-01', 'male', b'1'),
(22, 'wt1akqf7ds', '$2a$10$8/u.ex6dKwvgb3f/AtxbLeSVjisb5H6yNm5FmW7ErlyfcZCGZBX1S', 'h', 'h', 'paiboonpa@gmail.com', '1980-01-01', 'male', b'1'),
(23, 'wt1akqf7dsa', '$2a$10$tVLRFtuX6dlHno1FQg9OnOyOQuz0GTLGMaxtfCeD1ejXg//CxTdne', 'i', 'i', 'paiboonpa@gmail.com', '1980-01-01', 'male', b'1'),
(24, 'dbuser11', '$2a$10$ZO2GcB6ZlzkOkYBu3XTD8OEB2YnYjzb/.sheCk4CvQ0uYP7/PjWhi', 'z', 'z', 'z@z.com', '1980-01-01', 'male', b'1'),
(25, 'wt1akqf7s', '$2a$10$n7Y7F/wVWo/0ZsFtc.e.WOdDF7mDmP58yy1TW5Ll1dj8Uabvi1Mwq', 'j', 'j', 'paiboonpa@gmail.com', '1980-01-01', 'male', b'1'),
(26, 'a', '$2a$10$68Eipd431FlRFcTGgVxYUebySfZmPZBF8djAJgLt0PFRKCiFVmzdq', 'a', 'a', 'a@a.com', '1983-01-01', 'male', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `persistent_logins`
--

INSERT INTO `persistent_logins` (`username`, `series`, `token`, `last_used`) VALUES
('dbadmin1', 'BMHStUiR061OqmPKidR9gg==', 'e5KKSFAfj2hHyEadFHrjVQ==', '2019-05-03 04:53:12');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 2),
(5, 13, 2),
(6, 17, 1),
(7, 18, 2),
(8, 20, 2),
(9, 21, 2),
(10, 22, 2),
(11, 23, 2),
(12, 24, 2),
(13, 25, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `app_role`
--
ALTER TABLE `app_role`
  ADD PRIMARY KEY (`role_id`),
  ADD UNIQUE KEY `app_role_uk` (`role_name`);

--
-- Indexes for table `app_user`
--
ALTER TABLE `app_user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `app_user_uk` (`user_name`);

--
-- Indexes for table `persistent_logins`
--
ALTER TABLE `persistent_logins`
  ADD PRIMARY KEY (`series`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_role_uk` (`user_id`,`role_id`),
  ADD KEY `user_role_fk2` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `app_user`
--
ALTER TABLE `app_user`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
