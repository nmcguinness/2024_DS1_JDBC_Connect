--
-- Table structure for table `games`
--

CREATE TABLE `games` (
  `GameID` int(11) NOT NULL,
  `GameName` varchar(100) DEFAULT NULL,
  `ReleaseDate` date DEFAULT NULL,
  `Genre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `games`
--

INSERT INTO `games` (`GameID`, `GameName`, `ReleaseDate`, `Genre`) VALUES
(1, 'Space Invaders', '1978-06-01', 'Shooter'),
(2, 'Super Mario Bros', '1985-09-13', 'Platform'),
(3, 'The Legend of Zelda', '1986-02-21', 'Action-Adventure'),
(4, 'Minecraft', '2011-11-18', 'Sandbox');

-- --------------------------------------------------------

--
-- Table structure for table `playergames`
--

CREATE TABLE `playergames` (
  `PlayerID` int(11) NOT NULL,
  `GameID` int(11) NOT NULL,
  `PlayDate` date DEFAULT NULL,
  `Score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `playergames`
--

INSERT INTO `playergames` (`PlayerID`, `GameID`, `PlayDate`, `Score`) VALUES
(1, 1, '2023-12-01', 200),
(1, 2, '2023-12-02', 15000),
(2, 2, '2023-12-02', 12500),
(2, 4, '2023-12-06', 50000),
(3, 1, '2023-12-05', 180),
(3, 3, '2023-12-03', 300),
(4, 4, '2023-12-04', 45000);

-- --------------------------------------------------------

--
-- Table structure for table `players`
--

CREATE TABLE `players` (
  `PlayerID` int(11) NOT NULL,
  `FirstName` varchar(100) DEFAULT NULL,
  `LastName` varchar(100) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Birthdate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `players`
--

INSERT INTO `players` (`PlayerID`, `FirstName`, `LastName`, `Email`, `Birthdate`) VALUES
(1, 'John', 'Doe', 'johndoe@example.com', '1992-04-01'),
(2, 'Jane', 'Smith', 'janesmith@example.com', '1988-08-08'),
(3, 'Alice', 'Johnson', 'alicejohnson@example.com', '1995-11-15'),
(4, 'Bob', 'Lee', 'boblee@example.com', '1990-02-20');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `games`
--
ALTER TABLE `games`
  ADD PRIMARY KEY (`GameID`);

--
-- Indexes for table `playergames`
--
ALTER TABLE `playergames`
  ADD PRIMARY KEY (`PlayerID`,`GameID`),
  ADD KEY `GameID` (`GameID`);

--
-- Indexes for table `players`
--
ALTER TABLE `players`
  ADD PRIMARY KEY (`PlayerID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `playergames`
--
ALTER TABLE `playergames`
  ADD CONSTRAINT `playergames_ibfk_1` FOREIGN KEY (`PlayerID`) REFERENCES `players` (`PlayerID`),
  ADD CONSTRAINT `playergames_ibfk_2` FOREIGN KEY (`GameID`) REFERENCES `games` (`GameID`);
