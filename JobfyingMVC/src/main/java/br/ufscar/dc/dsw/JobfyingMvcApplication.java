package br.ufscar.dc.dsw;

import java.math.BigDecimal;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IEmpresaDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.dao.IVagaDAO;
import br.ufscar.dc.dsw.domain.Empresa;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Vaga;
import br.ufscar.dc.dsw.dao.ICandidaturaDAO;
import br.ufscar.dc.dsw.domain.Candidatura;

@SpringBootApplication
public class JobfyingMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobfyingMvcApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(IUsuarioDAO usuarioDAO, BCryptPasswordEncoder encoder, IEmpresaDAO empresaDAO, IVagaDAO vagaDAO, ICandidaturaDAO candidaturaDAO) {
        return (args) -> {

            // Criando 10 usuários com nomes reais
            Usuario u1 = new Usuario();
            u1.setUsername("johndoe");
            u1.setPassword(encoder.encode("password1"));
            u1.setCPF("123.456.789-00");
            u1.setName("John Doe");
            u1.setRole("ROLE_USER");
            u1.setEnabled(true);
            usuarioDAO.save(u1);

            Usuario u2 = new Usuario();
            u2.setUsername("janedoe");
            u2.setPassword(encoder.encode("password2"));
            u2.setCPF("234.567.890-01");
            u2.setName("Jane Doe");
            u2.setRole("ROLE_USER");
            u2.setEnabled(true);
            usuarioDAO.save(u2);

            Usuario u3 = new Usuario();
            u3.setUsername("robertsmith");
            u3.setPassword(encoder.encode("password3"));
            u3.setCPF("345.678.901-02");
            u3.setName("Robert Smith");
            u3.setRole("ROLE_USER");
            u3.setEnabled(true);
            usuarioDAO.save(u3);

            Usuario u4 = new Usuario();
            u4.setUsername("emilyjohnson");
            u4.setPassword(encoder.encode("password4"));
            u4.setCPF("456.789.012-03");
            u4.setName("Emily Johnson");
            u4.setRole("ROLE_USER");
            u4.setEnabled(true);
            usuarioDAO.save(u4);

            Usuario u5 = new Usuario();
            u5.setUsername("michaelbrown");
            u5.setPassword(encoder.encode("password5"));
            u5.setCPF("567.890.123-04");
            u5.setName("Michael Brown");
            u5.setRole("ROLE_USER");
            u5.setEnabled(true);
            usuarioDAO.save(u5);

            Usuario u6 = new Usuario();
            u6.setUsername("sarahdavis");
            u6.setPassword(encoder.encode("password6"));
            u6.setCPF("678.901.234-05");
            u6.setName("Sarah Davis");
            u6.setRole("ROLE_USER");
            u6.setEnabled(true);
            usuarioDAO.save(u6);

            Usuario u7 = new Usuario();
            u7.setUsername("davidmiller");
            u7.setPassword(encoder.encode("password7"));
            u7.setCPF("789.012.345-06");
            u7.setName("David Miller");
            u7.setRole("ROLE_USER");
            u7.setEnabled(true);
            usuarioDAO.save(u7);

            Usuario u8 = new Usuario();
            u8.setUsername("lauraanderson");
            u8.setPassword(encoder.encode("password8"));
            u8.setCPF("890.123.456-07");
            u8.setName("Laura Anderson");
            u8.setRole("ROLE_USER");
            u8.setEnabled(true);
            usuarioDAO.save(u8);


            Usuario u9 = new Usuario();
            u9.setUsername("admin");
            u9.setPassword(encoder.encode("admin"));
            u9.setCPF("901.234.567-08");
            u9.setName("admin");
            u9.setRole("ROLE_ADMIN");
            u9.setEnabled(true);
            usuarioDAO.save(u9);

            Usuario u10 = new Usuario();
            u10.setUsername("oliviamartinez");
            u10.setPassword(encoder.encode("password10"));
            u10.setCPF("012.345.678-09");
            u10.setName("Olivia Martinez");
            u10.setRole("ROLE_USER");
            u10.setEnabled(true);
            usuarioDAO.save(u10);

            // Criando 10 empresas com nomes reais
            Empresa e1 = new Empresa();
            e1.setCNPJ("11.111.111/0001-11");
            e1.setNome("Google LLC");
            empresaDAO.save(e1);

            Empresa e2 = new Empresa();
            e2.setCNPJ("22.222.222/0002-22");
            e2.setNome("Microsoft Corporation");
            empresaDAO.save(e2);

            Empresa e3 = new Empresa();
            e3.setCNPJ("33.333.333/0003-33");
            e3.setNome("Amazon.com, Inc.");
            empresaDAO.save(e3);

            Empresa e4 = new Empresa();
            e4.setCNPJ("44.444.444/0004-44");
            e4.setNome("Apple Inc.");
            empresaDAO.save(e4);

            Empresa e5 = new Empresa();
            e5.setCNPJ("55.555.555/0005-55");
            e5.setNome("Facebook, Inc.");
            empresaDAO.save(e5);

            Empresa e6 = new Empresa();
            e6.setCNPJ("66.666.666/0006-66");
            e6.setNome("Tesla, Inc.");
            empresaDAO.save(e6);

            Empresa e7 = new Empresa();
            e7.setCNPJ("77.777.777/0007-77");
            e7.setNome("Netflix, Inc.");
            empresaDAO.save(e7);

            Empresa e8 = new Empresa();
            e8.setCNPJ("88.888.888/0008-88");
            e8.setNome("Uber Technologies, Inc.");
            empresaDAO.save(e8);

            Empresa e9 = new Empresa();
            e9.setCNPJ("99.999.999/0009-99");
            e9.setNome("Twitter, Inc.");
            empresaDAO.save(e9);

            Empresa e10 = new Empresa();
            e10.setCNPJ("00.000.000/0010-00");
            e10.setNome("SpaceX");
            empresaDAO.save(e10);

            // Criando 15 vagas com títulos e descrições reais
            Vaga v1 = new Vaga();
            v1.setTitulo("Software Engineer");
            v1.setDescricao("Desenvolver e manter sistemas de software de alta qualidade.");
            v1.setCargaHoraria(40);
            v1.setSalario(BigDecimal.valueOf(12000.00));
            v1.setEmpresa(e1);
            vagaDAO.save(v1);

            Vaga v2 = new Vaga();
            v2.setTitulo("Data Scientist");
            v2.setDescricao("Analisar dados complexos para ajudar na tomada de decisões.");
            v2.setCargaHoraria(40);
            v2.setSalario(BigDecimal.valueOf(13000.00));
            v2.setEmpresa(e2);
            vagaDAO.save(v2);

            Vaga v3 = new Vaga();
            v3.setTitulo("Cloud Engineer");
            v3.setDescricao("Gerenciar e otimizar serviços em nuvem.");
            v3.setCargaHoraria(40);
            v3.setSalario(BigDecimal.valueOf(12500.00));
            v3.setEmpresa(e3);
            vagaDAO.save(v3);

            Vaga v4 = new Vaga();
            v4.setTitulo("Product Manager");
            v4.setDescricao("Supervisionar o desenvolvimento de produtos de tecnologia.");
            v4.setCargaHoraria(40);
            v4.setSalario(BigDecimal.valueOf(15000.00));
            v4.setEmpresa(e4);
            vagaDAO.save(v4);

            Vaga v5 = new Vaga();
            v5.setTitulo("DevOps Engineer");
            v5.setDescricao("Automatizar processos e gerenciar infraestrutura de TI.");
            v5.setCargaHoraria(40);
            v5.setSalario(BigDecimal.valueOf(14000.00));
            v5.setEmpresa(e5);
            vagaDAO.save(v5);

            Vaga v6 = new Vaga();
            v6.setTitulo("Frontend Developer");
            v6.setDescricao("Desenvolver interfaces de usuário para aplicações web.");
            v6.setCargaHoraria(40);
            v6.setSalario(BigDecimal.valueOf(11000.00));
            v6.setEmpresa(e6);
            vagaDAO.save(v6);

            Vaga v7 = new Vaga();
            v7.setTitulo("Backend Developer");
            v7.setDescricao("Desenvolver e manter a lógica do lado do servidor.");
            v7.setCargaHoraria(40);
            v7.setSalario(BigDecimal.valueOf(11500.00));
            v7.setEmpresa(e7);
            vagaDAO.save(v7);

            Vaga v8 = new Vaga();
            v8.setTitulo("UX/UI Designer");
            v8.setDescricao("Criar experiências de usuário intuitivas e atraentes.");
            v8.setCargaHoraria(40);
            v8.setSalario(BigDecimal.valueOf(10000.00));
            v8.setEmpresa(e8);
            vagaDAO.save(v8);

            Vaga v9 = new Vaga();
            v9.setTitulo("Mobile Developer");
            v9.setDescricao("Desenvolver e otimizar aplicações móveis para iOS e Android.");
            v9.setCargaHoraria(40);
            v9.setSalario(BigDecimal.valueOf(11500.00));
            v9.setEmpresa(e9);
            vagaDAO.save(v9);

            Vaga v10 = new Vaga();
            v10.setTitulo("AI Engineer");
            v10.setDescricao("Desenvolver soluções de inteligência artificial.");
            v10.setCargaHoraria(40);
            v10.setSalario(BigDecimal.valueOf(15000.00));
            v10.setEmpresa(e10);
            vagaDAO.save(v10);

            Vaga v11 = new Vaga();
            v11.setTitulo("Cybersecurity Analyst");
            v11.setDescricao("Monitorar e proteger sistemas contra ameaças cibernéticas.");
            v11.setCargaHoraria(40);
            v11.setSalario(BigDecimal.valueOf(13500.00));
            v11.setEmpresa(e1);
            vagaDAO.save(v11);

			Candidatura can1 = new Candidatura();
			can1.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
			can1.setSalario(v1.getSalario());
			can1.setVaga(v1);
			can1.setUsuario(u10);
            can1.setStatus("Aberto");
			candidaturaDAO.save(can1);

            Vaga v12 = new Vaga();
            v12.setTitulo("Network Engineer");
            v12.setDescricao("Planejar e gerenciar redes de comunicação.");
            v12.setCargaHoraria(40);
            v12.setSalario(BigDecimal.valueOf(12000.00));
            v12.setEmpresa(e2);
            vagaDAO.save(v12);

            Vaga v13 = new Vaga();
            v13.setTitulo("Systems Architect");
            v13.setDescricao("Projetar e supervisionar a arquitetura de sistemas de TI.");
            v13.setCargaHoraria(40);
            v13.setSalario(BigDecimal.valueOf(16000.00));
            v13.setEmpresa(e3);
            vagaDAO.save(v13);

            Vaga v14 = new Vaga();
            v14.setTitulo("QA Engineer");
            v14.setDescricao("Garantir a qualidade dos produtos de software.");
            v14.setCargaHoraria(40);
            v14.setSalario(BigDecimal.valueOf(11000.00));
            v14.setEmpresa(e4);
            vagaDAO.save(v14);

            Vaga v15 = new Vaga();
            v15.setTitulo("Technical Support Specialist");
            v15.setDescricao("Fornecer suporte técnico e resolver problemas de TI.");
            v15.setCargaHoraria(40);
            v15.setSalario(BigDecimal.valueOf(9000.00));
            v15.setEmpresa(e5);
            vagaDAO.save(v15);

        

            Candidatura can2 = new Candidatura();
            can2.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
            can2.setSalario(v2.getSalario());
            can2.setVaga(v2);
            can2.setUsuario(u10);
            can2.setStatus("Não Selecionado");
            candidaturaDAO.save(can2);

            Candidatura can3 = new Candidatura();
            can3.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
            can3.setSalario(v3.getSalario());
            can3.setVaga(v3);
            can3.setUsuario(u10);
            can3.setStatus("Entrevista");
            candidaturaDAO.save(can3);

            // Candidaturas para o usuário u9
            Candidatura can4 = new Candidatura();
            can4.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
            can4.setSalario(v4.getSalario());
            can4.setVaga(v4);
            can4.setUsuario(u9);
            can4.setStatus("Aberto");
            candidaturaDAO.save(can4);

            Candidatura can5 = new Candidatura();
            can5.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
            can5.setSalario(v5.getSalario());
            can5.setVaga(v5);
            can5.setUsuario(u9);
            can5.setStatus("Não Selecionado");
            candidaturaDAO.save(can5);

            Candidatura can6 = new Candidatura();
            can6.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
            can6.setSalario(v6.getSalario());
            can6.setVaga(v6);
            can6.setUsuario(u9);
            can6.setStatus("Entrevista");
            candidaturaDAO.save(can6);

            // Candidaturas para o usuário u8
            Candidatura can7 = new Candidatura();
            can7.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
            can7.setSalario(v7.getSalario());
            can7.setVaga(v7);
            can7.setUsuario(u8);
            can7.setStatus("Aberto");
            candidaturaDAO.save(can7);

            Candidatura can8 = new Candidatura();
            can8.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
            can8.setSalario(v8.getSalario());
            can8.setVaga(v8);
            can8.setUsuario(u8);
            can8.setStatus("Não Selecionado");
            candidaturaDAO.save(can8);

            Candidatura can9 = new Candidatura();
            can9.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
            can9.setSalario(v9.getSalario());
            can9.setVaga(v9);
            can9.setUsuario(u8);
            can9.setStatus("Entrevista");
            candidaturaDAO.save(can9);

            // Candidaturas para o usuário u7
            Candidatura can10 = new Candidatura();
            can10.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
            can10.setSalario(v10.getSalario());
            can10.setVaga(v10);
            can10.setUsuario(u7);
            can10.setStatus("Aberto");
            candidaturaDAO.save(can10);

            Candidatura can11 = new Candidatura();
            can11.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
            can11.setSalario(v11.getSalario());
            can11.setVaga(v11);
            can11.setUsuario(u7);
            can11.setStatus("Não Selecionado");
            candidaturaDAO.save(can11);

            Candidatura can12 = new Candidatura();
            can12.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
            can12.setSalario(v12.getSalario());
            can12.setVaga(v12);
            can12.setUsuario(u7);
            can12.setStatus("Entrevista");
            candidaturaDAO.save(can12);

            // Candidaturas para o usuário u6
            Candidatura can13 = new Candidatura();
            can13.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
            can13.setSalario(v13.getSalario());
            can13.setVaga(v13);
            can13.setUsuario(u6);
            can13.setStatus("Aberto");
            candidaturaDAO.save(can13);

            Candidatura can14 = new Candidatura();
            can14.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
            can14.setSalario(v14.getSalario());
            can14.setVaga(v14);
            can14.setUsuario(u6);
            can14.setStatus("Não Selecionado");
            candidaturaDAO.save(can14);

            Candidatura can15 = new Candidatura();
            can15.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
            can15.setSalario(v15.getSalario());
            can15.setVaga(v15);
            can15.setUsuario(u6);
            can15.setStatus("Entrevista");
            candidaturaDAO.save(can15);


            Usuario u20 = new Usuario();
            u20.setUsername("user20");
            u20.setPassword(encoder.encode("password"));
            u20.setCPF("678.785.234-97");
            u20.setName("User to remove");
            u20.setRole("ROLE_USER");
            u20.setEnabled(true);
            usuarioDAO.save(u20);
        };
    }
}
