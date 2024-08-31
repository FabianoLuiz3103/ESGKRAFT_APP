import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

import br.com.fiap.controller.PostController;
import br.com.fiap.redeSocial.Post;

public class teste {

	public static void main(String[] args) {
		
		PostController postController = null;
		try {
			postController = new PostController();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<String> tipos = new ArrayList<>();
		for(Post p : postController.listarPosts()) {
			tipos.add(p.getTipoESG());
		}
	     int contE = Collections.frequency(tipos, "E");
	     int contS = Collections.frequency(tipos, "S");
	     int contG = Collections.frequency(tipos, "G");
	     Gson gson = new Gson();
	     int[] numeroTipo = {contE, contS, contG};
	     System.out.println("E" + numeroTipo[0]);
	     System.out.println("S" + numeroTipo[1]);
	     System.out.println("G" + numeroTipo[2]);

	}

}
