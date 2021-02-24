library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity clock is
    Port ( clk : in STD_LOGIC; 
           bcd_unidade: in STD_LOGIC_VECTOR (3 downto 0); 
           bcd_dezena: in STD_LOGIC_VECTOR (3 downto 0); 
           bcd_centena: in STD_LOGIC_VECTOR (3 downto 0);
           bcd_milhares: in STD_LOGIC_VECTOR (3 downto 0);
           an: out STD_LOGIC_VECTOR (3 downto 0);
           seg: out STD_LOGIC_VECTOR (6 downto 0);
           dp: out std_logic);
end clock;

architecture Behavioral of clock is
    signal clock_lento : std_logic;
    signal counter: integer range 1 to 100_000 := 1;
    signal seletor_display: integer range 1 to 4 := 1;
    signal s_an: STD_LOGIC_VECTOR (3 downto 0);
    signal bcd_now: STD_LOGIC_VECTOR (3 downto 0);
    
component decodificadorBCD
    Port ( a : in STD_LOGIC_VECTOR (3 downto 0);
           seg : out STD_LOGIC_VECTOR (6 downto 0);
           dp : out STD_LOGIC);
end component;
    
begin
    divisor_clock: process(clk)
    begin
        if rising_edge(clk) then
            if counter = 100_000 then
                counter <= 1;
                clock_lento <= not clock_lento;
            else
                counter <= counter + 1;
            end if;
        end if;
    end process;
    
    selecionaDisplay: process(clock_lento)
    begin
        if rising_edge(clock_lento) then
            case seletor_display is
            when 1 =>  s_an <= "1110"; bcd_now <= bcd_unidade;
            when 2 =>  s_an <= "1101"; bcd_now <= bcd_dezena;
            when 3 =>  s_an <= "1011"; bcd_now <= bcd_centena;
            when 4 =>  s_an <= "0111"; bcd_now <= bcd_milhares;
            when others => null;
            end case;
            
            seletor_display <= seletor_display + 1;
        end if;
    
    end process;
    an <= s_an;
    bcd: decodificadorBCD port map (a => bcd_now, seg => seg, dp => dp);
end Behavioral;
