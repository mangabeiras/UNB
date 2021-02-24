library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity mux2 is
    Port ( a : in STD_LOGIC_VECTOR (3 downto 0);
           b : in STD_LOGIC_VECTOR (3 downto 0);
           z : out STD_LOGIC_VECTOR (3 downto 0);
           sel : in STD_LOGIC);
end mux2;

architecture Behavioral of mux2 is

begin
    with sel select
        z <= a when '0',
             b when '1';
end Behavioral;
