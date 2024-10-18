import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Consulta> consultas =new ArrayList<>();


        pacientes.add(new Paciente("Carlos", 18, "890.425.673-21"));
        pacientes.add(new Paciente("Arthur", 19, "754.214.643-53"));


        medicos.add(new Medico("Dr. Roberto", "12345678901", "Cardiologista", true));
        medicos.add(new Medico("Dr Marcos", "215475434", "Urologista", true));

        agendarConsulta(pacientes,medicos,consultas, "890.425.673-21","Cardiologista", "2024-10-07");
        agendarConsulta(pacientes,medicos,consultas, "754.214.643-53","Urologista", "2024-11-05");
        gerarRelatorioConsultas(consultas);
        listarConsultasPacientes(consultas, "890.425.673-21");
    }

    public static Paciente verPaciente(ArrayList<Paciente> pacientes, String cpf){
        for( Paciente p : pacientes){
            if(p.getCpf().equals(cpf)){
                return p;
            }
        }
        return null;
    }

    public static Medico verMedicos(ArrayList<Medico> medicos, String espacialidade){
        for(Medico m : medicos){
            if(m.getEspecialidade().equals(espacialidade) && m.isDisponibilidade()){
            return m;
            }
        }
        return null;
    }

    public static void agendarConsulta(ArrayList<Paciente> pacientes, ArrayList<Medico> medicos, ArrayList<Consulta> consultas,String cpfPaciente, String especialidade, String data){
        Paciente paciente = verPaciente(pacientes,cpfPaciente);
        Medico medico = verMedicos(medicos, especialidade);

        if(paciente != null && medico != null){
            Consulta consulta = new Consulta(paciente, medico, data);
            consultas.add(consulta);
            System.out.println("Consulta Agendada com sucesso!");

        }
        else{
            System.out.println("Não foi possivel agendar a consulta, verifique o paciente ou se o medico está disponivel.");
        }

    }

    public static void gerarRelatorioConsultas(ArrayList<Consulta> consultas){
        System.out.println("Relatório de consultas:\n");
        if(consultas.isEmpty()){
            System.out.println("Nenhuma consulta realizada.");
        }
        else{
            for(Consulta consulta : consultas){
                System.out.println(consultas);
            }
        }
    }

    public static void listarConsultasPacientes(ArrayList<Consulta> consultas, String cpfPaciente){
        String cpf = cpfPaciente;
        System.out.println("Consultas de paciente com CPF: " + cpf);
        boolean encontrar = false;
        for (Consulta consulta : consultas){
            if(consulta.getPaciente().getCpf().equals(cpf)){
                System.out.println(consulta);
                encontrar = true;
            }
            if(!encontrar){
                System.out.println("Nenhuma consulta encontrada para este paciente!");
            }

        }
    }

}