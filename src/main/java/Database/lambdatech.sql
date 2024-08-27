-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 27, 2024 at 08:22 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lambdatech`
--

-- --------------------------------------------------------

--
-- Table structure for table `assign`
--

CREATE TABLE `assign` (
  `emp_name` varchar(50) DEFAULT NULL,
  `dev_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `assign`
--

INSERT INTO `assign` (`emp_name`, `dev_name`) VALUES
('emp1', 'dev1'),
('emp2', 'dev2'),
('emp3', 'dev3'),
('emp4', 'dev4'),
('emp5', 'dev5');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `client_name` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `dob` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`client_name`, `password`, `email`, `phone`, `dob`) VALUES
('client1', 'password1', 'client1@example.com', '1234567890', '2024-08-08'),
('client2', 'password2', 'client2@example.com', '1234567891', '2024-08-08'),
('client3', 'password3', 'client3@example.com', '1234567892', '2024-08-08'),
('client4', 'password4', 'client4@example.com', '1234567893', '2024-08-08'),
('client5', 'password5', 'client5@example.com', '1234567894', '2024-08-08');

-- --------------------------------------------------------

--
-- Table structure for table `developer`
--

CREATE TABLE `developer` (
  `dev_name` varchar(50) NOT NULL,
  `designation` int(11) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `about` text DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `developer`
--

INSERT INTO `developer` (`dev_name`, `designation`, `password`, `email`, `about`, `phone`) VALUES
('dev1', 1, 'password1', 'dev1@example.com', 'About dev1', '1234567800'),
('dev2', 1, 'password2', 'dev2@example.com', 'About dev2', '1234567801'),
('dev3', 2, 'password3', 'dev3@example.com', 'About dev3', '1234567802'),
('dev4', 3, 'password4', 'dev4@example.com', 'About dev4', '1234567803'),
('dev5', 3, 'password5', 'dev5@example.com', 'About dev5', '1234567804'),
('hasan', 2, 'sdsad', 'sadasd', 'dfgdgsdf', 'sdsda'),
('jehan', 2, 'dsasd', 'sadsada', 'dsadas', 'sdadsas');

-- --------------------------------------------------------

--
-- Table structure for table `dev_domain`
--

CREATE TABLE `dev_domain` (
  `dev_name` varchar(50) DEFAULT NULL,
  `domain` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dev_domain`
--

INSERT INTO `dev_domain` (`dev_name`, `domain`) VALUES
('dev1', 'Web Development'),
('dev2', 'Mobile Development'),
('dev3', 'Data Science'),
('dev4', 'Machine Learning'),
('dev5', 'Cloud Computing'),
('hasan', 'python'),
('hasan', 'cpp');

-- --------------------------------------------------------

--
-- Table structure for table `dev_lang`
--

CREATE TABLE `dev_lang` (
  `dev_name` varchar(50) DEFAULT NULL,
  `language` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dev_lang`
--

INSERT INTO `dev_lang` (`dev_name`, `language`) VALUES
('dev1', 'JavaScript'),
('dev2', 'Python'),
('dev3', 'R'),
('dev4', 'Python'),
('dev5', 'Java');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `emp_name` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `manager_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_name`, `password`, `email`, `phone`, `manager_name`) VALUES
('emp1', 'password1', 'emp1@example.com', '1234567805', 'manager1'),
('emp2', 'password2', 'emp2@example.com', '1234567806', 'manager2'),
('emp3', 'password3', 'emp3@example.com', '1234567807', 'manager3'),
('emp4', 'password4', 'emp4@example.com', '1234567808', 'manager4'),
('emp5', 'password5', 'emp5@example.com', '1234567809', 'manager5');

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `manager_name` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`manager_name`, `password`, `phone`, `email`) VALUES
('manager1', 'password1', '1234567895', 'manager1@example.com'),
('manager2', 'password2', '1234567896', 'manager2@example.com'),
('manager3', 'password3', '1234567897', 'manager3@example.com'),
('manager4', 'password4', '1234567898', 'manager4@example.com'),
('manager5', 'password5', '1234567899', 'manager5@example.com');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `client_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`payment_id`, `amount`, `client_name`) VALUES
(1, 100.00, 'client1'),
(2, 200.00, 'client2'),
(3, 300.00, 'client3'),
(4, 400.00, 'client4'),
(5, 500.00, 'client5');

-- --------------------------------------------------------

--
-- Table structure for table `system`
--

CREATE TABLE `system` (
  `manager_name` varchar(50) DEFAULT NULL,
  `client_name` varchar(50) DEFAULT NULL,
  `system_title` varchar(100) DEFAULT NULL,
  `system_details` text DEFAULT NULL,
  `domain` varchar(50) DEFAULT NULL,
  `language` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `system`
--

INSERT INTO `system` (`manager_name`, `client_name`, `system_title`, `system_details`, `domain`, `language`) VALUES
('manager1', 'client1', 'Pubg', 'sfasdfsa', 'apps', 'flutter'),
('manager2', 'client2', 'Spotify', 'sdfsad', 'web', 'html'),
('manager3', 'client3', 'clock', 'sdasda', 'js', 'js'),
('manager4', 'client5', 'error_predict', 'sdaasd', 'ai', 'python'),
('manager5', 'client4', 'Dua Dua', 'sdasda', 'python', 'python'),
('manager4', 'client2', 'Doo DOo', 'sdsadas', 'web', 'html');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assign`
--
ALTER TABLE `assign`
  ADD KEY `emp_name` (`emp_name`),
  ADD KEY `dev_name` (`dev_name`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`client_name`);

--
-- Indexes for table `developer`
--
ALTER TABLE `developer`
  ADD PRIMARY KEY (`dev_name`);

--
-- Indexes for table `dev_domain`
--
ALTER TABLE `dev_domain`
  ADD KEY `dev_name` (`dev_name`);

--
-- Indexes for table `dev_lang`
--
ALTER TABLE `dev_lang`
  ADD KEY `dev_name` (`dev_name`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_name`),
  ADD KEY `manager_name` (`manager_name`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`manager_name`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `client_name` (`client_name`);

--
-- Indexes for table `system`
--
ALTER TABLE `system`
  ADD KEY `manager_name` (`manager_name`),
  ADD KEY `client_name` (`client_name`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assign`
--
ALTER TABLE `assign`
  ADD CONSTRAINT `assign_ibfk_1` FOREIGN KEY (`emp_name`) REFERENCES `employee` (`emp_name`),
  ADD CONSTRAINT `assign_ibfk_2` FOREIGN KEY (`dev_name`) REFERENCES `developer` (`dev_name`);

--
-- Constraints for table `dev_domain`
--
ALTER TABLE `dev_domain`
  ADD CONSTRAINT `dev_domain_ibfk_1` FOREIGN KEY (`dev_name`) REFERENCES `developer` (`dev_name`);

--
-- Constraints for table `dev_lang`
--
ALTER TABLE `dev_lang`
  ADD CONSTRAINT `dev_lang_ibfk_1` FOREIGN KEY (`dev_name`) REFERENCES `developer` (`dev_name`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`manager_name`) REFERENCES `manager` (`manager_name`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`client_name`) REFERENCES `client` (`client_name`);

--
-- Constraints for table `system`
--
ALTER TABLE `system`
  ADD CONSTRAINT `system_ibfk_1` FOREIGN KEY (`manager_name`) REFERENCES `manager` (`manager_name`),
  ADD CONSTRAINT `system_ibfk_2` FOREIGN KEY (`client_name`) REFERENCES `client` (`client_name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
