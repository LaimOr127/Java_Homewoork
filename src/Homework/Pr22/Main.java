

// Интерфейс для компьютерной конфигурации
interface ComputerConfig {
    void printConfig();
}

// Конкретная реализация компьютерной конфигурации PC
class PCConfig implements ComputerConfig {
    private String ram;
    private String hdd;
    private String cpu;

    public PCConfig(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public void printConfig() {
        System.out.println("AbstractFactory PC Config::RAM=" + ram + ", HDD=" + hdd + ", CPU=" + cpu);
    }
}

// Конкретная реализация компьютерной конфигурации сервера
class ServerConfig implements ComputerConfig {
    private String ram;
    private String hdd;
    private String cpu;

    public ServerConfig(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public void printConfig() {
        System.out.println("AbstractFactory Server Config::RAM=" + ram + ", HDD=" + hdd + ", CPU=" + cpu);
    }
}

// Абстрактная фабрика для создания компьютерных конфигураций
interface ComputerFactory {
    ComputerConfig createComputerConfig();
}

// Конкретная фабрика для создания PC-конфигураций
class PCConfigFactory implements ComputerFactory {
    @Override
    public ComputerConfig createComputerConfig() {
        return new PCConfig("2 GB", "500 GB", "2.4 GHz");
    }
}

// Конкретная фабрика для создания серверных конфигураций
class ServerConfigFactory implements ComputerFactory {
    @Override
    public ComputerConfig createComputerConfig() {
        return new ServerConfig("16 GB", "1 TB", "2.9 GHz");
    }
}

public class Main {
    public static void main(String[] args) {
        ComputerFactory pcFactory = new PCConfigFactory();
        ComputerFactory serverFactory = new ServerConfigFactory();

        ComputerConfig pcConfig = pcFactory.createComputerConfig();
        ComputerConfig serverConfig = serverFactory.createComputerConfig();

        pcConfig.printConfig();
        serverConfig.printConfig();
    }
}

