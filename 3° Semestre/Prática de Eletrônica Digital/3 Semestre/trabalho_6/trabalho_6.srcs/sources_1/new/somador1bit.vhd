library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity somador1bit is
    Port ( a : in STD_LOGIC;
           b : in STD_LOGIC;
           cin : in std_logic;
           cout: out std_logic;
           saida : out STD_LOGIC);
end somador1bit;

architecture Behavioral of somador1bit is

begin
    saida <= (a and (not b) and (not cin)) or ((not a) and (not b) and cin) or (a and b and cin) or ((not a) and b and (not cin));
    cout <= (a and b) or (a and cin)  or (cin and b);
end Behavioral;
