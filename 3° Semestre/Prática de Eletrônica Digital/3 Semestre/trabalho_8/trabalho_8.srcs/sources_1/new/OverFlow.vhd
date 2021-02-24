library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity OverFlow is
    Port ( a : in STD_LOGIC;
           b : in STD_LOGIC;
           c : in STD_LOGIC;
           saida : out STD_LOGIC);
end OverFlow;

architecture Behavioral of OverFlow is

begin
    saida <= ((not a) and (not b) and c) or (a and b and (not c));

end Behavioral;
