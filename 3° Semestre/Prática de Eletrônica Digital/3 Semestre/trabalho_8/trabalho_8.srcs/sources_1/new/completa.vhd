library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity completa is
    Port ( bcd1 : in STD_LOGIC_VECTOR (4 downto 0);
           bcd2 : in STD_LOGIC_VECTOR (4 downto 0);
           saida1 : out STD_LOGIC_VECTOR (4 downto 0);
           saida2 : out STD_LOGIC_VECTOR (4 downto 0));
end completa;

architecture Behavioral of completa is

begin
    saida1(4) <= bcd1(3);
    saida1(3) <= bcd1(3);
    saida1(2) <= bcd1(2);
    saida1(1) <= bcd1(1);
    saida1(0) <= bcd1(0);
    
    saida2(4) <= bcd2(3);
    saida2(3) <= bcd2(3);
    saida2(2) <= bcd2(2);
    saida2(1) <= bcd2(1);
    saida2(0) <= bcd2(0);

end Behavioral;
