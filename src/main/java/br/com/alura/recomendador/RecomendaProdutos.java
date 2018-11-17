package br.com.alura.recomendador;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.math.hadoop.similarity.cooccurrence.measures.PearsonCorrelationSimilarity;

public class RecomendaProdutos {
	public static void main(String[] args) throws IOException, TasteException {
		File file = new File("dados.csv");
		DataModel model = new FileDataModel(file);

		//Cria recomendador baseado no modelo
		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
		UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		
		//User 1
		System.out.println("usuario 1");
		List<RecommendedItem> recommendations = recommender.recommend(1, 4);
		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}
		//User 3
		System.out.println("usuario 3");
		recommendations = recommender.recommend(3, 4);
		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}
		
		//User 4
		System.out.println("usuario 4");
		recommendations = recommender.recommend(4, 4);
		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}
	}
}
