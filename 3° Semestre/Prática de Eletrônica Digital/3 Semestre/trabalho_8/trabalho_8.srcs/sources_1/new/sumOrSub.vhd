library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity sumOrSub is
    Port ( M : in STD_LOGIC;
           bcd : in STD_LOGIC_VECTOR (4 downto 0);
           saida : out STD_LOGIC_VECTOR (4 downto 0));
end sumOrSub;

architecture Behavioral of sumOrSub is
component somador4bit
    Port ( a : in STD_LOGIC_VECTOR (4 downto 0);
           b : in STD_LOGIC_VECTOR (4 downto 0);
           resultado : out STD_LOGIC_VECTOR (4 downto 0));
end component;

    signal bcdCompara, final, finalOne: STD_LOGIC_VECTOR (4 downto 0);
begin
    bcdCompara <= (not bcd);       
    somaNum1: somador4bit port map(a => bcdCompara, b => "00001", resultado => finalOne);
   
    saida <= finalOne when M ='1' else
             bcd;
end Behavioral;
