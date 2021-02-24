--COMPLEMENTO DE 1
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;


entity complemento1 is
    Port ( a : in STD_LOGIC;
           sel: in STD_LOGIC;
           s : out STD_LOGIC);
end complemento1;

architecture Behavioral of complemento1 is
component somador1b
    Port ( a : in STD_LOGIC;
           b : in STD_LOGIC;
           cin : in STD_LOGIC;
           s : out STD_LOGIC;
           cout : out STD_LOGIC);
end component;
   
begin
    s <= a xor sel;
      
end Behavioral;
