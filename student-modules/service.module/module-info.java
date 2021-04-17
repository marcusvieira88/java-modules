module service.module {
    requires client.module;
    provides tech.marcusvieira.student.client.Service with tech.marcusvieira.student.service.ServiceImpl;
}