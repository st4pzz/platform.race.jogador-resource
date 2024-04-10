package insper.store.jogador;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Jogador", description = "Jogador API")
public class JogadorResource implements JogadorController {

        @Autowired
        private JogadorService jogadorService;

        @GetMapping("/jogador/info")
        public ResponseEntity<Map<String, String>> info() {
                return new ResponseEntity<Map<String, String>>(
                                Map.ofEntries(
                                                Map.entry("microservice.name", JogadorApplication.class.getSimpleName()),
                                                Map.entry("os.arch", System.getProperty("os.arch")),
                                                Map.entry("os.name", System.getProperty("os.name")),
                                                Map.entry("os.version", System.getProperty("os.version")),
                                                Map.entry("file.separator", System.getProperty("file.separator")),
                                                Map.entry("java.class.path", System.getProperty("java.class.path")),
                                                Map.entry("java.home", System.getProperty("java.home")),
                                                Map.entry("java.vendor", System.getProperty("java.vendor")),
                                                Map.entry("java.vendor.url", System.getProperty("java.vendor.url")),
                                                Map.entry("java.version", System.getProperty("java.version")),
                                                Map.entry("line.separator", System.getProperty("line.separator")),
                                                Map.entry("path.separator", System.getProperty("path.separator")),
                                                Map.entry("user.dir", System.getProperty("user.dir")),
                                                Map.entry("user.home", System.getProperty("user.home")),
                                                Map.entry("user.name", System.getProperty("user.name")),
                                                Map.entry("jar", new java.io.File(
                                                                JogadorApplication.class.getProtectionDomain()
                                                                                .getCodeSource()
                                                                                .getLocation()
                                                                                .getPath())
                                                                .toString())),
                                HttpStatus.OK);
        }

        @Override
        @Operation(summary = "Create Jogador", description = "Create Jogador")
        public ResponseEntity<JogadorOut> create(JogadorIn in) {
                // parser
                Jogador jogador = JogadorParser.to(in);
                // insert using service
                jogador = jogadorService.create(jogador);
                // return
                return ResponseEntity.created(
                                ServletUriComponentsBuilder
                                                .fromCurrentRequest()
                                                .path("/{id}")
                                                .buildAndExpand(jogador.id())
                                                .toUri())
                                .body(JogadorParser.to(jogador));
        }

        @Override
        @Operation(summary = "Update Jogador", description = "Update Jogador")
        public ResponseEntity<JogadorOut> update(String id, JogadorIn in) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'update'");
        }

        @Override
        @Operation(summary = "Read Jogador", description = "Read Jogador")
        public ResponseEntity<JogadorOut> read(String idJogador) {
                Jogador jogador = jogadorService.read(idJogador);
                if (jogador == null) {
                        return ResponseEntity.notFound().build();
                }

                JogadorOut jogadorOut = JogadorParser.to(jogador);
                return ResponseEntity.ok(jogadorOut);
        }

}
