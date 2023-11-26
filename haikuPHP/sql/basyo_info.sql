-- データベースは自分のdocker desktopに保存されているが
-- 消えちゃった時用に一応入れておく


-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- ホスト: db
-- 生成日時: 2023 年 11 月 25 日 17:35
-- サーバのバージョン： 5.7.44
-- PHP のバージョン: 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- データベース: `haiku_db`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `basyo_info`
--

CREATE TABLE `basyo_info` (
  `id` int(11) NOT NULL,
  `username` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `comment` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- テーブルのデータのダンプ `basyo_info`
--

INSERT INTO `basyo_info` (`id`, `username`, `comment`, `date`) VALUES
(1, '尾崎放哉', 'せきをしてもひとり', '2023-11-25 07:49:58'),
(2, '真・芭蕉', 'ふるいけや かわすとびだす みずおとこ', '2023-11-25 17:23:33'),
(3, '名無しの芭蕉', 'ななしでも かわずとびこむ みずのおと', '2023-11-25 17:24:18'),
(4, '拗音芭蕉', 'ふるいきゃや かわずとびゅこむ みゅずのおと', '2023-11-25 19:50:41'),
(5, '芭蕉', 'さみだれを あつめてはやし もがみがわ', '2023-11-25 23:34:33');

--
-- ダンプしたテーブルのインデックス
--

--
-- テーブルのインデックス `basyo_info`
--
ALTER TABLE `basyo_info`
  ADD PRIMARY KEY (`id`);

--
-- ダンプしたテーブルの AUTO_INCREMENT
--

--
-- テーブルの AUTO_INCREMENT `basyo_info`
--
ALTER TABLE `basyo_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
