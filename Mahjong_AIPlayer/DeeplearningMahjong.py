import torch
import torch.nn as nn
import torch.optim as optim

class MahjongAIDeepLearning:
    def __init__(self):
        # 创建一个神经网络模型
        self.model = self.build_model()
        self.optimizer = optim.SGD(self.model.parameters(), lr=0.01)
        self.criterion = nn.CrossEntropyLoss()

    def build_model(self):
        # 创建一个简单的神经网络模型，用于碰牌决策
        model = nn.Sequential(
            nn.Linear(27, 128),  # 输入层，考虑27种不同的牌
            nn.ReLU(),
            nn.Linear(128, 2)  # 输出层，表示碰或不碰的两个类别
        )
        return model

    def train(self, training_data, num_epochs=100):
        # 训练神经网络模型
        for epoch in range(num_epochs):
            for input_data, target in training_data:
                output = self.model(input_data)
                loss = self.criterion(output, target)
                self.optimizer.zero_grad()
                loss.backward()
                self.optimizer.step()

    def make_peng_decision(self, player_hand, incoming_tile):
        # 将手牌和刚摸到的牌转化为神经网络的输入
        input_data = self.encode_input(player_hand, incoming_tile)
        # 使用神经网络进行碰牌决策
        output = self.model(input_data)
        # 根据输出选择动作
        if torch.argmax(output) == 0:
            return "Pass"
        else:
            return "Peng"

    def encode_input(self, player_hand, incoming_tile):
        # 将手牌和刚摸到的牌编码为神经网络的输入向量
        # 这是一个示例，具体编码方法可以根据需求调整
        input_vector = [0] * 27  # 27种不同的麻将牌
        for tile in player_hand:
            input_vector[tile] += 1
        input_vector[incoming_tile] += 1
        return torch.Tensor(input_vector)

# 示例用法
player_hand = [1, 1, 2, 3, 4, 5, 6]
incoming_tile = 1
ai = MahjongAIDeepLearning()

# 训练神经网络，training_data应包括输入数据和相应的标签
# training_data = [(input_data1, target1), (input_data2, target2), ...]
# ai.train(training_data, num_epochs=100)

decision = ai.make_peng_decision(player_hand, incoming_tile)
print("Player's decision:", decision)
