----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 10/15/2020 09:31:05 PM
-- Design Name: 
-- Module Name: complemento2 - Behavioral
-- Project Name: 
-- Target Devices: 
-- Tool Versions: 
-- Description: 
-- 
-- Dependencies: 
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
-- 
----------------------------------------------------------------------------------


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity overflow is
    Port ( COUT : in STD_LOGIC;
           S : out STD_LOGIC;
           OVER: out String);
           
end overflow;

architecture Behavioral of overflow is
    signal c1: STD_LOGIC;

begin
    S <= COUT and '1';
    OVER <= "OVERFLOW";
    
end Behavioral;
