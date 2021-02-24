library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity decodificadorBCD is
    Port ( a : in STD_LOGIC_VECTOR (3 downto 0);
           seg : out STD_LOGIC_VECTOR (6 downto 0);
           dp : out STD_LOGIC);
end decodificadorBCD;

architecture Behavioral of decodificadorBCD is
    signal dp_now: std_logic;
begin
    with a select
        seg <= "1000000" when "0000", --0
               "1111001" when "0001", --1
               "0100100" when "0010", --2
               "0110000" when "0011", --3
               "0011001" when "0100", --4
               "0010010" when "0101", --5
               "0000010" when "0110", --6
               "1111000" when "0111", --7
               
               "1111001" when "1111", --'-1'
               "0100100" when "1110", --'-2'
               "0110000" when "1101", --'-3'
               "0011001" when "1100", --'-4'
               "0010010" when "1011", --'-5'
               "0000010" when "1010", --'-6'
               "1111000" when "1001", --'-7'
               "0000000" when "1000", --'-8'
               "1111111" when others;
     
      fazDp: process(a(3))
      begin
        if a(3) = '1' then
            dp_now <= '0';
         else
            dp_now <= '1';
        end if;   
      end process;
      dp <= dp_now;
end Behavioral;
