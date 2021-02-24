library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity transformador is
    Port ( a : in STD_LOGIC_VECTOR (4 downto 0);
           bcd_1 : out STD_LOGIC_VECTOR (3 downto 0);
           bcd_2 : out STD_LOGIC_VECTOR (3 downto 0));
end transformador;

architecture Behavioral of transformador is
    signal troca : STD_LOGIC_VECTOR (3 downto 0);
begin
    troca(3) <= a(3);
    troca(2) <= a(2);
    troca(1) <= a(1);
    troca(0) <= a(0);
    with a select
        bcd_1 <= "0001" when "01010",
                 "0001" when "01011",
                 "0001" when "01100",
                 "0001" when "01101",
                 "0001" when "01110",
                 "0001" when "01111",
                 "0001" when "10110",
                 "0001" when "10101",
                 "0001" when "10100",
                 "0001" when "10011",
                 "0001" when "10010",
                 "0001" when "10001",
                 "0000" when others;

    with a select
        bcd_2 <= "0000" when "01010",
                 "0001" when "01011",
                 "0010" when "01100",
                 "0011" when "01101",
                 "0100" when "01110",
                 "0101" when "01111",
                 "0000" when "10110",
                 "1111" when "10101",
                 "1110" when "10100",
                 "1101" when "10011",
                 "1100" when "10010",
                 "1011" when "10001",
                 troca when others;
end Behavioral;
